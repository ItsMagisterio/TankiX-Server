package tx.server.protocol

import kotlin.collections.set
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlinx.datetime.Instant
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tx.server.ecs.entities.IEntity
import tx.server.ecs.entities.templates.TemplateAccessor
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.ICodec
import tx.server.protocol.codec.complex.CommandCodec
import tx.server.protocol.codec.complex.EntityCodec
import tx.server.protocol.codec.complex.TemplateAccessorCodec
import tx.server.protocol.codec.container.array.ByteArrayCodec
import tx.server.protocol.codec.factory.*
import tx.server.protocol.codec.info.ICodecInfo
import tx.server.protocol.codec.info.TypeCodecInfo
import tx.server.protocol.codec.primitive.*
import tx.server.protocol.command.*
import tx.server.utils.IClassScanner

fun IEntity.toShareCommand() = EntityShareCommand(
  entityId = id,
  templateAccessor = templateAccessor,
  components = components.toTypedArray()
)

fun IEntity.toUnshareCommand() = EntityUnshareCommand(entity = this)

val KClass<*>.protocolId: ProtocolId
  get() = requireNotNull(findAnnotation()) { "Missing @ProtocolId on ${this.simpleName}" }

class Protocol : IProtocol, KoinComponent {
  private val logger = KotlinLogging.logger { }

  private val classScanner: IClassScanner by inject()

  private val types: MutableMap<Long, KClass<*>> = mutableMapOf()
  private val codecs: MutableMap<ICodecInfo, ICodec<*>> = mutableMapOf()
  private val factories: MutableList<ICodecFactory> = mutableListOf()

  init {
    register(Boolean::class, BooleanCodec())
    register(Byte::class, ByteCodec())
    register(UByte::class, UByteCodec())
    register(Short::class, ShortCodec())
    register(UShort::class, UShortCodec())
    register(Int::class, IntCodec())
    register(UInt::class, UIntCodec())
    register(Long::class, LongCodec())
    register(ULong::class, ULongCodec())
    register(Float::class, FloatCodec())
    register(Double::class, DoubleCodec())
    register(String::class, StringCodec())
    register(Instant::class, InstantCodec())

    // Arrays of primitives
    register(ByteArray::class, ByteArrayCodec())

    // ECS
    register(TemplateAccessor::class, TemplateAccessorCodec())
    register(IEntity::class, EntityCodec())

    register(ICommand::class, CommandCodec().apply {
      register(EntityShareCommand::class, CommandCode.EntityShare)
      register(EntityUnshareCommand::class, CommandCode.EntityUnshare)
      register(ComponentAddCommand::class, CommandCode.ComponentAdd)
      register(ComponentRemoveCommand::class, CommandCode.ComponentRemove)
      register(ComponentChangeCommand::class, CommandCode.ComponentChange)
      register(SendEventCommand::class, CommandCode.SendEvent)
      register(InitTimeCommand::class, CommandCode.InitTime)
      register(CloseCommand::class, CommandCode.Close)
    })

    factories.add(ArrayCodecFactory())
    factories.add(ListCodecFactory())
    factories.add(SetCodecFactory())
    factories.add(MapCodecFactory())
    factories.add(EnumCodecFactory())
    factories.add(GroupComponentCodecFactory())
    factories.add(VariedCodecFactory())
    factories.add(OptionalCodecFactory())
    factories.add(StructCodecFactory())

    classScanner.getAnnotatedWith(ProtocolId::class).forEach { type ->
      types[type.protocolId.id] = type
    }
  }

  fun <T : Any> register(type: KClass<T>, codec: ICodec<T>) {
    initAndRegister(TypeCodecInfo(type), codec)
    // initAndRegister(TypeCodecInfo(type, true), OptionalCodec(codec))
  }

  fun initAndRegister(info: ICodecInfo, codec: ICodec<*>) {
    (codec as Codec<*>).init(this)
    codecs[info] = codec
  }

  override fun getCodecRaw(info: ICodecInfo): ICodec<*> {
    // Get direct
    codecs[info]?.let { return it }

    // TODO: Get hierarchical (predicate.type assignable to info.type)

    return createCodec(info)
  }

  private fun createCodec(info: ICodecInfo): ICodec<*> {
    var codec: ICodec<*>?

    // Try to create from factories
    for(factory in factories) {
      codec = factory.create(this@Protocol, info) ?: continue
      // logger.debug { "Created $codec with $factory for $info" }

      (codec as Codec<*>).init(this)
      // TODO: Cache codec (by constructor arguments?)
      return codec
    }

    // TODO: Try to create hierarchical, see ProtocolImpl#CreateCodecIfNecessary() in client

    throw IllegalArgumentException("Codec for $info not found")
  }

  override fun getTypeById(id: Long): KClass<*> {
    return requireNotNull(types[id]) { "Type $id is not registered" }
  }
}

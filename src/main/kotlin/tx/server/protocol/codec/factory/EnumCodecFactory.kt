package tx.server.protocol.codec.factory

import kotlin.reflect.KClass
import kotlin.reflect.full.createType
import kotlin.reflect.full.findAnnotation
import tx.server.extensions.kotlinClass
import tx.server.protocol.Protocol
import tx.server.protocol.ProtocolType
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.container.EnumCodec
import tx.server.protocol.codec.info.ICodecInfo
import tx.server.protocol.codec.info.ITypeCodecInfo

class EnumCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is ITypeCodecInfo || !info.type.kotlinClass.java.isEnum) return null

    val enumType = info.type.kotlinClass as KClass<IProtocolEnum<Any>>
    val valueType = requireNotNull(enumType.findAnnotation<ProtocolType>()) { "No @ProtocolType annotation on enum ${info.type}" }.type as KClass<Any>
    return EnumCodec(enumType, valueType.createType())
  }
}

interface IProtocolEnum<T : Any> {
  val value: T
}

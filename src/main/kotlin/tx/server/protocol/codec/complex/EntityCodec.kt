package tx.server.protocol.codec.complex

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tx.server.ecs.entities.IEntity
import tx.server.ecs.entities.IEntityRegistry
import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.info.TypeCodecInfo
import tx.server.protocol.getCodec

class EntityCodec : Codec<IEntity>(), KoinComponent {
  private val entityRegistry: IEntityRegistry by inject()

  override suspend fun encode(buffer: ProtocolBuffer, value: IEntity) {
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value.id)
  }

  override suspend fun decode(buffer: ProtocolBuffer): IEntity {
    val id = protocol.getCodec<Long>(TypeCodecInfo(Long::class)).decode(buffer)
    return entityRegistry.get(id)
  }
}

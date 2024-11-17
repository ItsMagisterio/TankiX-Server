package tx.server.protocol.codec.complex

import tx.server.ecs.components.group.GroupComponent
import tx.server.extensions.kotlinClass
import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.info.TypeCodecInfo
import tx.server.protocol.getCodec
import tx.server.protocol.protocolId

class GroupComponentCodec : Codec<GroupComponent>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: GroupComponent) {
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value::class.protocolId.id)
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value.key)
  }

  override suspend fun decode(buffer: ProtocolBuffer): GroupComponent {
    val id = protocol.getCodec<Long>(TypeCodecInfo(Long::class)).decode(buffer)
    val type = protocol.getTypeById(id)

    val key = protocol.getCodec<Long>(TypeCodecInfo(Long::class)).decode(buffer)

    return type.constructors
      .single { it.parameters.single().type.kotlinClass == Long::class }
      .call(key) as GroupComponent
  }
}

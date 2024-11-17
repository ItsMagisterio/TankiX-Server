package tx.server.protocol.codec.container

import kotlin.reflect.KClass
import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.info.TypeCodecInfo
import tx.server.protocol.getCodec
import tx.server.protocol.protocolId

class VariedTypeCodec : Codec<KClass<*>>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: KClass<*>) {
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value.protocolId.id)
  }

  override suspend fun decode(buffer: ProtocolBuffer): KClass<*> {
    val id = protocol.getCodec<Long>(TypeCodecInfo(Long::class)).decode(buffer)
    return protocol.getTypeById(id)
  }
}

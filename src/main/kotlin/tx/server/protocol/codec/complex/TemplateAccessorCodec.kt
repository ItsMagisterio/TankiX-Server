package tx.server.protocol.codec.complex

import tx.server.ecs.entities.templates.TemplateAccessor
import tx.server.ecs.entities.templates.id
import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.info.TypeCodecInfo
import tx.server.protocol.getCodec

class TemplateAccessorCodec : Codec<TemplateAccessor>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: TemplateAccessor) {
    protocol.getCodec<Long>(TypeCodecInfo(Long::class)).encode(buffer, value.template::class.id)
    protocol.getCodec<String?>(TypeCodecInfo(String::class, true)).encode(buffer, value.configPath)
  }

  override suspend fun decode(buffer: ProtocolBuffer): TemplateAccessor {
    TODO("Not yet implemented")
  }
}

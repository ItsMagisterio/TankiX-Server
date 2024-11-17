package tx.server.protocol.codec.factory

import tx.server.protocol.Protocol
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.container.OptionalCodec
import tx.server.protocol.codec.info.ICodecInfo
import tx.server.protocol.codec.info.TypeCodecInfo

class OptionalCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is TypeCodecInfo || !info.nullable) return null

    // println("Create OptionalCodec for $info -> ${protocol.getCodecRaw(info.copy(nullable = false))}")
    return OptionalCodec(protocol.getCodecRaw(info.copy(nullable = false)))
  }
}

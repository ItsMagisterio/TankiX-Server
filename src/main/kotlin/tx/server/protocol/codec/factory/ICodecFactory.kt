package tx.server.protocol.codec.factory

import tx.server.protocol.Protocol
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.info.ICodecInfo

interface ICodecFactory {
  fun create(protocol: Protocol, info: ICodecInfo): Codec<*>?
}

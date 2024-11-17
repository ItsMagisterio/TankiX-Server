package tx.server.protocol.codec.factory

import kotlin.reflect.KClass
import tx.server.extensions.kotlinClass
import tx.server.protocol.Protocol
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.container.VariedStructCodec
import tx.server.protocol.codec.container.VariedTypeCodec
import tx.server.protocol.codec.info.ICodecInfo
import tx.server.protocol.codec.info.TypeCodecInfo

class VariedCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is TypeCodecInfo || !info.varied) return null

    return if(info.type.kotlinClass == KClass::class) VariedTypeCodec()
    else VariedStructCodec()
  }
}

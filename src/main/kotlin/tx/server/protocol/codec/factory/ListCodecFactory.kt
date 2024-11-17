package tx.server.protocol.codec.factory

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.isSubclassOf
import tx.server.extensions.kotlinClass
import tx.server.protocol.Protocol
import tx.server.protocol.ProtocolCollection
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.container.ListCodec
import tx.server.protocol.codec.info.ICodecInfo
import tx.server.protocol.codec.info.ITypeCodecInfo
import tx.server.protocol.codec.info.TypeCodecInfo

class ListCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is ITypeCodecInfo || !info.type.kotlinClass.isSubclassOf(List::class)) return null

    val annotation = info.type.findAnnotation() ?: ProtocolCollection.Default
    return ListCodec<Any>(
      TypeCodecInfo(
        type = requireNotNull(info.type.arguments.single().type) { "Invalid List<T> generic argument" },
        annotation.nullable,
        annotation.varied
      )
    )
  }
}

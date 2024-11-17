package tx.server.protocol.codec.factory

import tx.server.extensions.kotlinClass
import tx.server.extensions.singleOfOrNull
import tx.server.protocol.Protocol
import tx.server.protocol.ProtocolCollection
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.container.array.ArrayCodec
import tx.server.protocol.codec.info.ICodecInfo
import tx.server.protocol.codec.info.ITypeCodecInfo
import tx.server.protocol.codec.info.TypeCodecInfo

class ArrayCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is ITypeCodecInfo || !info.type.kotlinClass.java.isArray) return null

    val type = info.type.kotlinClass.java.componentType
    if(type.isPrimitive) error("No primitive array codec available for ${type.kotlin}")

    val annotation = info.annotations.singleOfOrNull() ?: ProtocolCollection.Default
    return ArrayCodec<Any>(
      TypeCodecInfo(
        type = type.kotlin,
        annotation.nullable,
        annotation.varied
      )
    )
  }
}

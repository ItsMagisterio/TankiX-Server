package tx.server.protocol.codec.factory

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.isSubclassOf
import tx.server.extensions.kotlinClass
import tx.server.protocol.Protocol
import tx.server.protocol.ProtocolMap
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.container.MapCodec
import tx.server.protocol.codec.info.ICodecInfo
import tx.server.protocol.codec.info.ITypeCodecInfo
import tx.server.protocol.codec.info.TypeCodecInfo

class MapCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is ITypeCodecInfo || !info.type.kotlinClass.isSubclassOf(Map::class)) return null

    val annotation = info.type.findAnnotation() ?: ProtocolMap.Default
    val arguments = info.type.arguments

    return MapCodec<Any, Any>(
      requireNotNull(arguments[0].type) { "Invalid Map<K, V> generic argument K" }.let { type ->
        TypeCodecInfo(type, annotation.key.nullable, annotation.key.varied)
      },
      requireNotNull(arguments[0].type) { "Invalid Map<K, V> generic argument V" }.let { type ->
        TypeCodecInfo(type, annotation.value.nullable, annotation.value.varied)
      }
    )
  }
}

package tx.server.protocol.codec.factory

import kotlin.reflect.full.isSubclassOf
import tx.server.ecs.components.group.GroupComponent
import tx.server.extensions.kotlinClass
import tx.server.protocol.Protocol
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.complex.GroupComponentCodec
import tx.server.protocol.codec.info.ICodecInfo
import tx.server.protocol.codec.info.TypeCodecInfo

class GroupComponentCodecFactory : ICodecFactory {
  override fun create(protocol: Protocol, info: ICodecInfo): Codec<*>? {
    if(info !is TypeCodecInfo || !info.type.kotlinClass.isSubclassOf(GroupComponent::class)) return null

    return GroupComponentCodec()
  }
}

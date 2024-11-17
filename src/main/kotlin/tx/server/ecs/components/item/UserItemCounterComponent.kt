package tx.server.ecs.components.item

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1479807693001)
data class UserItemCounterComponent(
  val count: Long
) : IComponent

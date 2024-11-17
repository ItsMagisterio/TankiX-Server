package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1482920154068)
data class UserSubscribeComponent(
  val subscribed: Boolean
) : IComponent

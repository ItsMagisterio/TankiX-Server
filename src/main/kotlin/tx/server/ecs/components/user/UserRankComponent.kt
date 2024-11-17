package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(-1413405458500615976)
data class UserRankComponent(
  val rank: Int
) : IComponent

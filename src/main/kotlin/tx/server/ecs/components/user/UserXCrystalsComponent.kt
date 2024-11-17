package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1473074767785)
data class UserXCrystalsComponent(
  val money: Long
) : IComponent

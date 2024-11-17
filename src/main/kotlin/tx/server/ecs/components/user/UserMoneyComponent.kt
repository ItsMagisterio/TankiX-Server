package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(9171752353079252620)
data class UserMoneyComponent(
  val money: Long
) : IComponent

package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1457515023113)
data class ConfirmedUserEmailComponent(
  val email: String,
  val subscribed: Boolean
) : IComponent

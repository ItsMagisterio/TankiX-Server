package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1482675132842)
data class UserIncompleteRegistrationComponent(
  val firstBattleDone: Boolean
) : IComponent

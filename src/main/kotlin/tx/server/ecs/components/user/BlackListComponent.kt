package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1507197930106)
data class BlackListComponent(
  val blockedUsers: List<Long>
) : IComponent

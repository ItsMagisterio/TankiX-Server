package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId
import tx.server.protocol.ProtocolName

@ProtocolId(-5477085396086342998)
data class UserUidComponent(
  @ProtocolName("uid") val username: String
) : IComponent

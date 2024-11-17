package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(-777019732837383198)
data class UserExperienceComponent(
  val experience: Long
) : IComponent

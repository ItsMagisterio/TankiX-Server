package tx.server.ecs.components.user

import kotlinx.datetime.Instant
import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1439270018242)
data class RegistrationDateComponent(
  val date: Instant?
) : IComponent

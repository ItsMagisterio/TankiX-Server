package tx.server.ecs.components.entrance.restorePassword

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1479198715562)
data class RestorePasswordCodeSentComponent(
  val email: String
) : IComponent

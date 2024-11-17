package tx.server.ecs.events.entrance.validation

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1460402823575)
data class RestorePasswordCodeInvalidEvent(
  val code: String
) : IEvent

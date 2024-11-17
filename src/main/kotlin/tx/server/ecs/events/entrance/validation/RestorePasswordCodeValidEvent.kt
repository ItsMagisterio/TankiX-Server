package tx.server.ecs.events.entrance.validation

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1460402875430)
data class RestorePasswordCodeValidEvent(
  val code: String
) : IEvent

package tx.server.ecs.events.entrance.validation

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1455866538339L)
data class EmailInvalidEvent(
  val email: String
) : IEvent

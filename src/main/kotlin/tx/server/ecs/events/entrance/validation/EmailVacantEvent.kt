package tx.server.ecs.events.entrance.validation

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(635906273700499964)
data class EmailVacantEvent(
  val email: String
) : IEvent

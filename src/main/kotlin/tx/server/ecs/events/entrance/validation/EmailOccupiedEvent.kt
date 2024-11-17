package tx.server.ecs.events.entrance.validation

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(635906273457089964)
data class EmailOccupiedEvent(
  val email: String
) : IEvent

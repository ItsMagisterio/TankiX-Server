package tx.server.ecs.events.payment

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1470652819513)
data class GoToPaymentRequestEvent(
  val steamIsActive: Boolean,
  val steamId: String,
  val ticket: String
) : IEvent

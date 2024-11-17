package tx.server.ecs.events.payment

import tx.server.ecs.PromoCodeCheckResult
import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1490937016798)
data class PromoCodeCheckResultEvent(
  val code: String,
  val result: PromoCodeCheckResult
) : IEvent

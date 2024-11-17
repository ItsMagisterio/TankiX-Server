package tx.server.ecs.events.payment

import tx.server.ecs.PaymentStatisticsAction
import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1471252962981)
data class PaymentStatisticsEvent(
  val action: PaymentStatisticsAction,
  val item: Long,
  val method: Long,
  val screen: String
) : IEvent

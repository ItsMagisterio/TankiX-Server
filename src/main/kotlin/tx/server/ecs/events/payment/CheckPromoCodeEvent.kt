package tx.server.ecs.events.payment

import tx.server.ecs.PromoCodeCheckResult
import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.network.send
import tx.server.protocol.ProtocolId

@ProtocolId(1490931976968)
data class CheckPromoCodeEvent(
  val code: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    if(code == "7FA8-8E12-DB08") connection.send(PromoCodeCheckResultEvent(code, PromoCodeCheckResult.EXPIRED))
    else connection.send(PromoCodeCheckResultEvent(code, PromoCodeCheckResult.NOT_FOUND))
  }
}

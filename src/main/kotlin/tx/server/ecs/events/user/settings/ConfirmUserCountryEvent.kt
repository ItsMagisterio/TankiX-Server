package tx.server.ecs.events.user.settings

import tx.server.ecs.components.user.UserCountryComponent
import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(1465192871085)
data class ConfirmUserCountryEvent(
  val countryCode: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    connection.player.countryCode = countryCode
    connection.user.changeComponent(UserCountryComponent(countryCode))
  }
}

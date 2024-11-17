package tx.server.ecs.events.user.settings

import tx.server.ecs.components.user.UserSubscribeComponent
import tx.server.ecs.entities.IEntity
import tx.server.ecs.entities.removeComponent
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(1482844606270)
data class SubscribeChangeEvent(
  val subscribed: Boolean
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    connection.player.subscribed = subscribed

    if(subscribed) connection.user.addComponent(UserSubscribeComponent(true))
    else connection.user.removeComponent<UserSubscribeComponent>()
  }
}

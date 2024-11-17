package tx.server.ecs.events.entrance

import mu.KotlinLogging
import tx.server.ecs.components.entrance.WebIdComponent
import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(1478774431678)
data class ClientLaunchEvent(
  val webId: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }

    connection.clientSession.addComponent(WebIdComponent())

    logger.debug { "Executed launch event" }
  }
}

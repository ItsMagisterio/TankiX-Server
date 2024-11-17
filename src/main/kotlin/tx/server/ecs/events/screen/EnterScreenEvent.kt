package tx.server.ecs.events.screen

import mu.KotlinLogging
import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(1453867134827)
data class EnterScreenEvent(
  val screen: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }

    logger.debug { "$connection entered screen $screen" }
  }
}

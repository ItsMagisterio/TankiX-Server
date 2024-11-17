package tx.server.protocol.command

import mu.KotlinLogging
import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IEvent
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolPosition
import tx.server.protocol.ProtocolVaried

class SendEventCommand(
  @ProtocolVaried
  @ProtocolPosition(0) val event: IEvent,
  @ProtocolPosition(1) val entities: Array<IEntity>
) : ICommand {
  override suspend fun execute(connection: IPlayerConnection) {
    val logger = KotlinLogging.logger { }

    if(event !is IServerEvent) {
      logger.warn { "Event ${event::class} is not a IServerEvent" }
      return
    }

    logger.info { "Received event $event for ${entities.size} entities" }
    event.execute(connection, entities)
  }
}

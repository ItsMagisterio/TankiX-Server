package tx.server.protocol.command

import mu.KotlinLogging
import tx.server.ecs.components.IComponent
import tx.server.ecs.entities.IEntity
import tx.server.ecs.entities.IEntityInternal
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolPosition
import tx.server.protocol.ProtocolVaried

class ComponentChangeCommand(
  entity: IEntity,
  @ProtocolVaried
  @ProtocolPosition(1) val component: IComponent
) : EntityCommand(entity) {
  override suspend fun execute(connection: IPlayerConnection) {
    val logger = KotlinLogging.logger { }

    (entity as IEntityInternal).changeComponent(component, excluded = connection)
    logger.debug { "$connection changed $component in $entity" }
  }
}

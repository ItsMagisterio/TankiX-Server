package tx.server.protocol.command

import kotlin.reflect.KClass
import tx.server.ecs.components.IComponent
import tx.server.ecs.entities.IEntity
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolPosition
import tx.server.protocol.ProtocolVaried

class ComponentRemoveCommand(
  entity: IEntity,
  @ProtocolVaried
  @ProtocolPosition(1) val component: KClass<out IComponent>
) : EntityCommand(entity) {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}

package tx.server.protocol.command

import tx.server.ecs.components.IComponent
import tx.server.ecs.entities.templates.TemplateAccessor
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolCollection
import tx.server.protocol.ProtocolPosition

class EntityShareCommand(
  @ProtocolPosition(0) val entityId: Long,
  @ProtocolPosition(1) val templateAccessor: TemplateAccessor?,
  @ProtocolCollection(varied = true)
  @ProtocolPosition(2) val components: Array<IComponent>
) : ICommand {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}

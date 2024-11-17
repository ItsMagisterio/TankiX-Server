package tx.server.protocol.command

import tx.server.ecs.entities.IEntity
import tx.server.protocol.ProtocolPosition

abstract class EntityCommand(
  @ProtocolPosition(0) val entity: IEntity
) : ICommand

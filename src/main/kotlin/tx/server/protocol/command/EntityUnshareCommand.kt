package tx.server.protocol.command

import tx.server.ecs.entities.IEntity
import tx.server.network.IPlayerConnection

class EntityUnshareCommand(entity: IEntity) : EntityCommand(entity) {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}

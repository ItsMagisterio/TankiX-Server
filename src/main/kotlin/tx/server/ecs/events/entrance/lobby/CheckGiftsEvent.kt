package tx.server.ecs.events.entrance.lobby

import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(636446543585160318)
class CheckGiftsEvent : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    // TODO
  }
}

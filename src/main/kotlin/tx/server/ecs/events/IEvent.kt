package tx.server.ecs.events

import tx.server.ecs.entities.IEntity
import tx.server.network.IPlayerConnection

interface IEvent
interface IServerEvent : IEvent {
  suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>)
}

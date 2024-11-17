package tx.server.ecs.events.entrance.validation

import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.network.send
import tx.server.protocol.ProtocolId
import tx.server.protocol.ProtocolName

@ProtocolId(1437990639822)
data class CheckUserUidEvent(
  @ProtocolName("uid") val username: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    if(username == "taken") connection.send(UserUidOccupiedEvent(username))
    else connection.send(UserUidVacantEvent(username))
  }
}

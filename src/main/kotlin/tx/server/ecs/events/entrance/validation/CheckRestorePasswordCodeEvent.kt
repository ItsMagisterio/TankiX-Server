package tx.server.ecs.events.entrance.validation

import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.network.send
import tx.server.protocol.ProtocolId

@ProtocolId(1460402752765)
data class CheckRestorePasswordCodeEvent(
  val code: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    if(code == "valid") connection.send(RestorePasswordCodeValidEvent(code))
    else connection.send(RestorePasswordCodeInvalidEvent(code))
  }
}

package tx.server.ecs.events.entrance.login

import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(1437480091995)
data class LoginByPasswordEvent(
  val passwordEncipher: String,
  val rememberMe: Boolean,
  val hardwareFingerprint: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) =
    connection.login(rememberMe, passwordEncipher, hardwareFingerprint)
}

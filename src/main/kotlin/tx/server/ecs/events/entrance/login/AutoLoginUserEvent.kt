package tx.server.ecs.events.entrance.login

import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.network.send
import tx.server.protocol.ProtocolId

@ProtocolId(1438075609642)
data class AutoLoginUserEvent(
  val uid: String,
  val encryptedToken: ByteArray,
  val hardwareFingerprint: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    // TODO
    connection.send(AutoLoginFailedEvent())
  }
}

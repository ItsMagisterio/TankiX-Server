package tx.server.ecs.events.entrance.restorePassword

import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(1460403525230)
data class RequestChangePasswordEvent(
  val passwordDigest: String,
  val hardwareFingerprint: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    // todo Save

    connection.login(true, passwordDigest, hardwareFingerprint)
  }
}

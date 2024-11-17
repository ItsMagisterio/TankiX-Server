package tx.server.ecs.events.entrance.restorePassword

import tx.server.ecs.Player
import tx.server.ecs.components.entrance.restorePassword.RestorePasswordCodeSentComponent
import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(1460106433434)
data class RestorePasswordByEmailEvent(
  val email: String
) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    connection.player = Player(email.substringBefore('@'), email)

    connection.clientSession.addComponent(RestorePasswordCodeSentComponent(email))
  }
}

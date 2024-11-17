package tx.server.ecs.events.entrance.registration

import tx.server.ecs.entities.IEntity
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.protocol.ProtocolId

@ProtocolId(1453881244963)
data class IncrementRegistrationNicksEvent(val nick: String) : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    // TODO(Assasans): Statistics?
  }
}

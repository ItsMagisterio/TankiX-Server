package tx.server.ecs.events.entrance.invite

import tx.server.ecs.components.entrance.invite.InviteComponent
import tx.server.ecs.entities.IEntity
import tx.server.ecs.entities.getComponent
import tx.server.ecs.events.IServerEvent
import tx.server.network.IPlayerConnection
import tx.server.network.send
import tx.server.protocol.ProtocolId

@ProtocolId(1439810001590)
class InviteEnteredEvent : IServerEvent {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val code = connection.clientSession.getComponent<InviteComponent>().inviteCode

    if(code == "invalid") connection.send(InviteDoesNotExistEvent())
    else connection.send(CommenceRegistrationEvent())
  }
}

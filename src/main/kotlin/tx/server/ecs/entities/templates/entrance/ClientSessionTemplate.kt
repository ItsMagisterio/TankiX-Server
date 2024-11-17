package tx.server.ecs.entities.templates.entrance

import tx.server.ecs.components.entrance.ClientSessionComponent
import tx.server.ecs.components.entrance.SessionSecurityPublicComponent
import tx.server.ecs.components.entrance.invite.InviteComponent
import tx.server.ecs.entities.component
import tx.server.ecs.entities.templates.IEntityTemplate
import tx.server.ecs.entities.templates.entity
import tx.server.protocol.ProtocolId

@ProtocolId(1429771189777)
object ClientSessionTemplate : IEntityTemplate {
  fun create() = entity(null) {
    component(ClientSessionComponent())
    component(SessionSecurityPublicComponent("AKhRLW42cTisWpRwUs3EfgLbs1xj32NVOEPwzMUdQiAHWEowCbIBSi0W45P550kTy0U6WKLl3MfFC+bTZ6voG15d:AQAB"))
    component(InviteComponent(inviteCode = null, showScreenOnEntrance = false))
  }
}

package tx.server.ecs.components.entrance

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1439792100478)
data class SessionSecurityPublicComponent(
  val publicKey: String
) : IComponent

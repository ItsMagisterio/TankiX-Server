package tx.server.ecs.components.entrance

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1453796862447)
data class ClientLocaleComponent(
  val localeCode: String
) : IComponent

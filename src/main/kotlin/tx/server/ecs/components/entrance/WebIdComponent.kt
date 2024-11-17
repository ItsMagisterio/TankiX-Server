package tx.server.ecs.components.entrance

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1479820450460)
data class WebIdComponent(
  val webId: String = "",
  val utm: String = "",
  val googleAnalyticsId: String = "",
  val webIdUid: String = ""
) : IComponent

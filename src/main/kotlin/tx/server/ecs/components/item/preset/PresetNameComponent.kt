package tx.server.ecs.components.item.preset

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1493974995307)
data class PresetNameComponent(
  val name: String
) : IComponent

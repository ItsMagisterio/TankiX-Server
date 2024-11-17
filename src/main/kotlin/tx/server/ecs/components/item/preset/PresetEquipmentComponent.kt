package tx.server.ecs.components.item.preset

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1502886877871)
data class PresetEquipmentComponent(
  val weaponId: Long,
  val hullId: Long
) : IComponent

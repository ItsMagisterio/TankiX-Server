package tx.server.ecs.components.fraction

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1544956558339)
data class RestrictionByUserFractionComponent(
  var fractionId: Long = 0
) : IComponent

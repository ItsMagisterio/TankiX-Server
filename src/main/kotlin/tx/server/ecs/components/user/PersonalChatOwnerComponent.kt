package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId
import tx.server.protocol.ProtocolName

@ProtocolId(1513067769958)
data class PersonalChatOwnerComponent(
  @ProtocolName("ChatIs") val chatIds: List<Long>
) : IComponent

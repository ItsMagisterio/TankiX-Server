package tx.server.ecs.events.user.friends

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1451120695251)
data class FriendsLoadedEvent(
  val acceptedFriendsIds: Set<Long>,
  val incomingFriendsIds: Set<Long>,
  val outgoingFriendsIds: Set<Long>
) : IEvent

package tx.server.ecs.events.entrance.validation

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId
import tx.server.protocol.ProtocolName

@ProtocolId(1437991666522L)
class UserUidVacantEvent(
  @ProtocolName("uid") val username: String
) : IEvent

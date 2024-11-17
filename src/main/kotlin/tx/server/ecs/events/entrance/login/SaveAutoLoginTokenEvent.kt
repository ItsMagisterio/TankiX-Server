package tx.server.ecs.events.entrance.login

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId
import tx.server.protocol.ProtocolName

@ProtocolId(1438070264777)
data class SaveAutoLoginTokenEvent(
  @ProtocolName("uid") val username: String,
  val token: ByteArray
) : IEvent

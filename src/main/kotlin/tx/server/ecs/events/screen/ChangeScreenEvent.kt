package tx.server.ecs.events.screen

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1504160222978)
data class ChangeScreenEvent(
  val currentScreen: String,
  val nextScreen: String,
  val duration: Double
) : IEvent

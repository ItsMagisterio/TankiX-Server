package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1545809085571)
class UserAvatarComponent(
  var id: String = "ce4faab6-c441-49f7-9106-8d31c5dcd148" // morocco avatar id
) : IComponent {
  init {
    //todo config deserializer
  }
}

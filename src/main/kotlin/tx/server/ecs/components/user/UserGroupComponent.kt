package tx.server.ecs.components.user

import tx.server.ecs.components.group.GroupComponent
import tx.server.ecs.entities.IEntity
import tx.server.protocol.ProtocolId

@ProtocolId(7453043498913563889)
class UserGroupComponent(key: Long) : GroupComponent(key) {
  constructor(entity: IEntity) : this(entity.id)
}

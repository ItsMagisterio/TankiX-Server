package tx.server.ecs.components.group

import tx.server.ecs.entities.IEntity
import tx.server.protocol.ProtocolId

@ProtocolId(635908808598551080)
class ParentGroupComponent(key: Long) : GroupComponent(key) {
  constructor(entity: IEntity) : this(entity.id)
}

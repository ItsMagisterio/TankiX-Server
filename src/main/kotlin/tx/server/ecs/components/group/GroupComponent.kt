package tx.server.ecs.components.group

import tx.server.ecs.components.IComponent
import tx.server.ecs.entities.IEntity

abstract class GroupComponent(
  val key: Long
) : IComponent {
  constructor(entity: IEntity) : this(entity.id)
}

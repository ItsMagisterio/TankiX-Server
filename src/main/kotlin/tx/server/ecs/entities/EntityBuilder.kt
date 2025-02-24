package tx.server.ecs.entities

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tx.server.ecs.components.IComponent
import tx.server.ecs.entities.templates.TemplateAccessor
import tx.server.extensions.inject

class EntityBuilder(override val id: Long) : IEntityBuilder, KoinComponent {
  private val entityRegistry: IEntityRegistry by inject()

  override var templateAccessor: TemplateAccessor? = null
  override val components: MutableSet<IComponent> = mutableSetOf()

  override fun build(): IEntity {
    val entity = Entity(id, templateAccessor, components.toTypedArray())
    entityRegistry.add(entity)

    return entity
  }
}

inline fun entity(id: Long, block: IEntityBuilder.() -> Unit): IEntity = EntityBuilder(id).apply(block).build()
inline fun entity(block: IEntityBuilder.() -> Unit): IEntity {
  val entityRegistry: IEntityRegistry by inject()
  return entity(entityRegistry.freeId, block)
}

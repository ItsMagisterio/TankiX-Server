package tx.server.ecs.entities.templates.user

import tx.server.ecs.Player
import tx.server.ecs.PlayerGroup
import tx.server.ecs.components.quest.QuestReadyComponent
import tx.server.ecs.components.user.*
import tx.server.ecs.entities.component
import tx.server.ecs.entities.templates.IEntityTemplate
import tx.server.ecs.entities.templates.entity
import tx.server.protocol.ProtocolId

@ProtocolId(1433752208915)
object UserTemplate : IEntityTemplate {
  fun create(player: Player) = entity("") {
    component(UserComponent())
    component(UserOnlineComponent())
    component(UserPublisherComponent())
    component(RegistrationDateComponent(player.registrationTime))

    component(UserUidComponent(player.username))
    component(UserCountryComponent(player.countryCode))
    component(UserSubscribeComponent(player.subscribed))
    component(ConfirmedUserEmailComponent(player.email, player.subscribed))

    component(PersonalChatOwnerComponent(listOf()))

    component(BlackListComponent(listOf()))

    component(UserExperienceComponent(player.experience))
    component(UserRankComponent(63))

    component(UserMoneyComponent(player.crystals))
    component(UserXCrystalsComponent(player.xCrystals))

    component(QuestReadyComponent())

    if(player.groups.contains(PlayerGroup.Admin)) component(UserAdminComponent())
    if(player.groups.contains(PlayerGroup.Tester)) component(ClosedBetaQuestAchievementComponent())
  }.also { it.addComponent(UserGroupComponent(it)) }
}

package tx.server.ecs.events.entrance.login

import tx.server.ecs.events.IServerEvent

abstract class IntroduceUserEvent(
  val captcha: String?
) : IServerEvent

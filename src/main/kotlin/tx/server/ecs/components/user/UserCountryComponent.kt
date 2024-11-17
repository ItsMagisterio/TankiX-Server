package tx.server.ecs.components.user

import tx.server.ecs.components.IComponent
import tx.server.protocol.ProtocolId

@ProtocolId(1470735489716)
data class UserCountryComponent(
  val countryCode: String
) : IComponent

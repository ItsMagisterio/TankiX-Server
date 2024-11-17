package tx.server.ecs.events.entrance.login

import tx.server.ecs.events.IEvent
import tx.server.protocol.ProtocolId

@ProtocolId(1439531278716)
data class PersonalPasscodeEvent(val passcode: String) : IEvent

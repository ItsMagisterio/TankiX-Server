package tx.server.ecs.events.entrance.login

import kotlin.random.Random
import io.ktor.util.*
import mu.KotlinLogging
import tx.server.ecs.Player
import tx.server.ecs.entities.IEntity
import tx.server.network.IPlayerConnection
import tx.server.network.send
import tx.server.protocol.ProtocolId

@ProtocolId(1458846544326)
class IntroduceUserByEmailEvent(
  captcha: String?,
  val email: String
) : IntroduceUserEvent(captcha) {
  override suspend fun execute(connection: IPlayerConnection, entities: Array<IEntity>) {
    val logger = KotlinLogging.logger { }

    logger.debug { "Login by email: $email" }

    connection.player = Player(email.substringBefore('@'), email)
    connection.send(PersonalPasscodeEvent(Random.nextBytes(32).encodeBase64())) // Same as hash length (SHA-256)
  }
}

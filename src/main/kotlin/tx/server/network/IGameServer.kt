package tx.server.network

import kotlin.coroutines.coroutineContext
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import kotlinx.coroutines.*
import kotlinx.datetime.Clock
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import tx.server.ecs.entities.templates.entrance.ClientSessionTemplate
import tx.server.protocol.command.InitTimeCommand
import tx.server.utils.IWithCoroutineScope

interface IGameServer : IWithCoroutineScope {
  suspend fun bind()
  suspend fun accept()
  suspend fun stop()
}

class GameServer : IGameServer, KoinComponent {
  private val logger = KotlinLogging.logger { }

  private lateinit var server: ServerSocket

  override lateinit var coroutineScope: CoroutineScope

  override suspend fun bind() {
    server = aSocket(SelectorManager(Dispatchers.IO)).tcp().bind("0.0.0.0", 5050)
    logger.info { "Started game server at ${server.localAddress}" }
  }

  override suspend fun accept() {
    coroutineScope = CoroutineScope(coroutineContext + SupervisorJob())

    while(!server.isClosed) {
      val socket = server.accept()
      logger.info { "Accepted ${socket.remoteAddress}" }

      val connection: IPlayerConnection = SocketPlayerConnection(socket)
      coroutineScope.launch {
        launch {
          val clientSession = ClientSessionTemplate.create()

          connection.send(InitTimeCommand(Clock.System.now().toEpochMilliseconds()))
          connection.share(clientSession)
          connection.clientSession = clientSession
        }

        launch { connection.receive() }
        launch { connection.decodeCommands() }
        launch { connection.sendCommands() }
      }
    }
  }

  override suspend fun stop() {
    withContext(Dispatchers.IO) { server.close() }
  }
}

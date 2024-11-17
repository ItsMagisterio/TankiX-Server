package tx.server

import com.github.ajalt.clikt.core.CliktCommand
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import org.koin.logger.SLF4JLogger
import tx.server.config.ClientConfigGenerator
import tx.server.config.IClientConfigGenerator
import tx.server.ecs.entities.EntityRegistry
import tx.server.ecs.entities.IEntityRegistry
import tx.server.extensions.get
import tx.server.extensions.inject
import tx.server.network.GameServer
import tx.server.network.IGameServer
import tx.server.network.config.ConfigServer
import tx.server.network.config.IConfigServer
import tx.server.protocol.IProtocol
import tx.server.protocol.Protocol
import tx.server.resources.IResourceManager
import tx.server.resources.ResourceManager
import tx.server.utils.IClassScanner
import tx.server.utils.IStartupTimer
import tx.server.utils.ReflectionsClassScanner
import tx.server.utils.StartupTimer

fun main(args: Array<String>) = object : CliktCommand() {
  private val logger = KotlinLogging.logger("tx.server.MainKt")

  private fun startKoin(startupTimer: IStartupTimer) {
    val module = module {
      /* Core */
      single<IStartupTimer> { startupTimer }
      single<IClassScanner> { ReflectionsClassScanner() }
      single<IResourceManager> { ResourceManager() }

      /* Network */
      single<IProtocol> { Protocol() }
      single<IGameServer> { GameServer() }
      single<IConfigServer> { ConfigServer() }
      single<IClientConfigGenerator> { ClientConfigGenerator() }

      /* ECS */
      single<IEntityRegistry> { EntityRegistry() }
    }

    startKoin {
      logger(SLF4JLogger(Level.ERROR))
      modules(module)
    }
  }

  override fun run(): Unit = runBlocking {

    val startupTimer = StartupTimer()
    startupTimer.start()

    startKoin(startupTimer)

    get<IResourceManager>().init()

    val configServer by inject<IConfigServer>()
    configServer.start()

    val gameServer by inject<IGameServer>()
    gameServer.bind()
    launch { gameServer.accept() }
  }
}.main(args)

package tx.server.protocol.command

import tx.server.network.IPlayerConnection

class InitTimeCommand(
  val serverTime: Long
) : ICommand {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}

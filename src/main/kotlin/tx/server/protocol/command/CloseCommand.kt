package tx.server.protocol.command

import tx.server.network.IPlayerConnection

class CloseCommand(
  val reason: String
) : ICommand {
  override suspend fun execute(connection: IPlayerConnection) {
    TODO("Not yet implemented")
  }
}

package tx.server.protocol.command

import tx.server.network.IPlayerConnection

interface ICommand {
  suspend fun execute(connection: IPlayerConnection)
}

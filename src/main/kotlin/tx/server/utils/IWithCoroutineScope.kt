package tx.server.utils

import kotlinx.coroutines.CoroutineScope

interface IWithCoroutineScope {
  val coroutineScope: CoroutineScope
}

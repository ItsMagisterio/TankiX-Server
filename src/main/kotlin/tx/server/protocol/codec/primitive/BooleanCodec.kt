package tx.server.protocol.codec.primitive

import io.ktor.utils.io.*
import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec

class BooleanCodec : Codec<Boolean>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Boolean) = buffer.writer.writeBoolean(value)
  override suspend fun decode(buffer: ProtocolBuffer): Boolean = buffer.reader.readBoolean()
}

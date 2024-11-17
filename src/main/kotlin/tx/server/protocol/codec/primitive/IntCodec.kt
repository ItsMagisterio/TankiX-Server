package tx.server.protocol.codec.primitive

import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec

class IntCodec : Codec<Int>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Int) = buffer.writer.writeInt(value)
  override suspend fun decode(buffer: ProtocolBuffer): Int = buffer.reader.readInt()
}

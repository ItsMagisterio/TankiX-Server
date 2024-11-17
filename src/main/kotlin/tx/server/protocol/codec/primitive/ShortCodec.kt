package tx.server.protocol.codec.primitive

import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec

class ShortCodec : Codec<Short>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Short) = buffer.writer.writeShort(value)
  override suspend fun decode(buffer: ProtocolBuffer): Short = buffer.reader.readShort()
}

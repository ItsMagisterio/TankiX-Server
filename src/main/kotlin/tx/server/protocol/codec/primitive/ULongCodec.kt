package tx.server.protocol.codec.primitive

import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec

class ULongCodec : Codec<ULong>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: ULong) = buffer.writer.writeLong(value.toLong())
  override suspend fun decode(buffer: ProtocolBuffer): ULong = buffer.reader.readLong().toULong()
}

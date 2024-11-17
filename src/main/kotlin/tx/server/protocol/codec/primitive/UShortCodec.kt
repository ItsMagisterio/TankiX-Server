package tx.server.protocol.codec.primitive

import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec

class UShortCodec : Codec<UShort>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: UShort) = buffer.writer.writeShort(value.toShort())
  override suspend fun decode(buffer: ProtocolBuffer): UShort = buffer.reader.readShort().toUShort()
}

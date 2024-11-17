package tx.server.protocol.codec.primitive

import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec

class ByteCodec : Codec<Byte>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: Byte) = buffer.writer.writeByte(value)
  override suspend fun decode(buffer: ProtocolBuffer): Byte = buffer.reader.readByte()
}

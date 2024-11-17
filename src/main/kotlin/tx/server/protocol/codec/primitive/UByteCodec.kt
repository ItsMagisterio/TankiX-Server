package tx.server.protocol.codec.primitive

import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec

class UByteCodec : Codec<UByte>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: UByte) = buffer.writer.writeByte(value.toByte())
  override suspend fun decode(buffer: ProtocolBuffer): UByte = buffer.reader.readByte().toUByte()
}

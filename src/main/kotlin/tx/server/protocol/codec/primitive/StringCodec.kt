package tx.server.protocol.codec.primitive

import tx.server.extensions.readNBytes
import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.VarIntCodecHelper

class StringCodec : Codec<String>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: String) {
    val bytes = value.toByteArray()
    VarIntCodecHelper.encode(buffer.writer, bytes.size)
    buffer.writer.writeFully(bytes, 0, bytes.size)
  }

  override suspend fun decode(buffer: ProtocolBuffer): String {
    val count = VarIntCodecHelper.decode(buffer.reader)
    return buffer.reader.readNBytes(count).decodeToString()
  }
}

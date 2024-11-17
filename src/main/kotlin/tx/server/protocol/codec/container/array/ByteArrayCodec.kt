package tx.server.protocol.codec.container.array

import tx.server.network.ProtocolBuffer
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.VarIntCodecHelper
import tx.server.protocol.codec.info.TypeCodecInfo
import tx.server.protocol.getCodec

class ByteArrayCodec : Codec<ByteArray>() {
  override suspend fun encode(buffer: ProtocolBuffer, value: ByteArray) {
    VarIntCodecHelper.encode(buffer.writer, value.size)
    value.forEach { buffer.writer.writeByte(it) }
  }

  override suspend fun decode(buffer: ProtocolBuffer): ByteArray {
    val elementCodec = protocol.getCodec<Byte>(TypeCodecInfo(Byte::class))

    val count = VarIntCodecHelper.decode(buffer.reader)
    val array = ByteArray(count)
    for(index in 0 until count) {
      array[index] = elementCodec.decode(buffer)
    }
    return array
  }
}

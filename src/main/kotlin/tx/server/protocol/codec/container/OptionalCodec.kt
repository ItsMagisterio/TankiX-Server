package tx.server.protocol.codec.container

import tx.server.network.ProtocolBuffer
import tx.server.protocol.IProtocol
import tx.server.protocol.codec.Codec
import tx.server.protocol.codec.ICodec

class OptionalCodec<T>(val codec: ICodec<T>) : Codec<T?>() {
  init {
    require(codec !is OptionalCodec<*>) { "OptionalCodec can not be used as inner codec for OptionalCodec" }
  }

  override fun init(protocol: IProtocol) {
    super.init(protocol)
    codec.init(protocol)
  }

  override suspend fun encode(buffer: ProtocolBuffer, value: T?) {
    buffer.optionalMap.add(value == null)
    if(value == null) return

    codec.encode(buffer, value)
  }

  override suspend fun decode(buffer: ProtocolBuffer): T? {
    if(buffer.optionalMap.get()) return null
    return codec.decode(buffer)
  }
}

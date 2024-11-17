package tx.server.protocol

import kotlin.reflect.KClass
import tx.server.extensions.cast
import tx.server.protocol.codec.ICodec
import tx.server.protocol.codec.info.ICodecInfo

interface IProtocol {
  fun getCodecRaw(info: ICodecInfo): ICodec<*>

  fun getTypeById(id: Long): KClass<*>
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T> IProtocol.getCodec(info: ICodecInfo): ICodec<T> = getCodecRaw(info).cast()

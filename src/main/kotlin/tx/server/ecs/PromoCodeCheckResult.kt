package tx.server.ecs

import tx.server.protocol.ProtocolType
import tx.server.protocol.codec.factory.IProtocolEnum

@ProtocolType(Byte::class)
enum class PromoCodeCheckResult(
  override val value: Byte
) : IProtocolEnum<Byte> {
  VALID(0),
  NOT_FOUND(1),
  USED(2),
  EXPIRED(3),
  INVALID(4),
  OWNED(5)
}

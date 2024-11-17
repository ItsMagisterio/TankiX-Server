package tx.server.protocol

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ProtocolId(val id: Long)

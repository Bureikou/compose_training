package jp.co.faith.playlog_android.data.network.model

data class ErrorResponse(
    val status: String,
    val errors: Errors?,
    val `data`: List<ErrorData>?

) {
    val fullMessage: String
        get() {
            return let {
                val sb = StringBuilder()
                errors?.full_messages?.forEach { sb.append(it) }
                sb.toString()
            }
        }
}

data class Errors(
    val full_messages: String
)

data class ErrorData(
    val resource: String?,
    val field: String?,
    val message: String?
)

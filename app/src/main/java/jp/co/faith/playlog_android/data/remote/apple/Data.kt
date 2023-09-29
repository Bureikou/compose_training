package jp.co.faith.playlog_android.data.remote.apple


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val attributes: Attributes?,
    val href: String?,
    val id: String?,
    val type: String?
)
package jp.co.faith.playlog_android.data.remote.apple


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayParams(
    val id: String?,
    val kind: String?
)
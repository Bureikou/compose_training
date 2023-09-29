package jp.co.faith.playlog_android.data.remote.spotify.search


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    val height: Int?,
    val url: String?,
    val width: Int?
)
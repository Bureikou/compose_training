package jp.co.faith.playlog_android.data.remote.spotify.search


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExternalUrlsX(
    val spotify: String?
)
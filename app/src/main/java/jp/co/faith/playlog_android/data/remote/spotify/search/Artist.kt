package jp.co.faith.playlog_android.data.remote.spotify.search


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Artist(
    @Json(name = "external_urls")
    val externalUrls: ExternalUrlsX?,
    val href: String?,
    val id: String?,
    val name: String?,
    val type: String?,
    val uri: String?
)
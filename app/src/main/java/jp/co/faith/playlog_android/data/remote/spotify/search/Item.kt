package jp.co.faith.playlog_android.data.remote.spotify.search


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "album_type")
    val albumType: String?,
    val artists: List<Artist>?,
    @Json(name = "external_urls")
    val externalUrls: ExternalUrlsX?,
    val href: String?,
    val id: String?,
    val images: List<Image>?,
    @Json(name = "is_playable")
    val isPlayable: Boolean?,
    val name: String?,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "release_date_precision")
    val releaseDatePrecision: String?,
    @Json(name = "total_tracks")
    val totalTracks: Int?,
    val type: String?,
    val uri: String?
)
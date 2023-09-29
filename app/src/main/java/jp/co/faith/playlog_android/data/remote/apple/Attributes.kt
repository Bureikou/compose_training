package jp.co.faith.playlog_android.data.remote.apple


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attributes(
    val artistName: String?,
    val artwork: Artwork?,
    val copyright: String?,
    val genreNames: List<String?>?,
    val isCompilation: Boolean?,
    val isComplete: Boolean?,
    val isMasteredForItunes: Boolean?,
    val isSingle: Boolean?,
    val name: String?,
    val playParams: PlayParams?,
    val recordLabel: String?,
    val releaseDate: String?,
    val trackCount: Int?,
    val upc: String?,
    val url: String?
)
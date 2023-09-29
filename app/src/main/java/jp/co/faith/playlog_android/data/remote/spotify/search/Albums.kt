package jp.co.faith.playlog_android.data.remote.spotify.search


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Albums(
    val href: String?,
    val items: List<Item>?,
    val limit: Int?,
    val next: String?,
    val offset: Int?,
    val previous: Any?,
    val total: Int?
)
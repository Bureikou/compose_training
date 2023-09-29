package jp.co.faith.playlog_android.data.remote.apple


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Artwork(
    val bgColor: String?,
    val height: Int?,
    val textColor1: String?,
    val textColor2: String?,
    val textColor3: String?,
    val textColor4: String?,
    val url: String?,
    val width: Int?
)
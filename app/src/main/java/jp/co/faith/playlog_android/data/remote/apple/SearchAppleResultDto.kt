package jp.co.faith.playlog_android.data.remote.apple


import com.squareup.moshi.JsonClass
import jp.co.faith.playlog_android.domain.model.AppleAlbum

@JsonClass(generateAdapter = true)
data class SearchAppleResultDto(
    val meta: Meta?,
    val results: ResultsX?
)

fun SearchAppleResultDto.toAlbums(): List<AppleAlbum> {
    return results!!.albums!!.data!!.map {
        AppleAlbum(
            id = it?.id,
            name = it!!.attributes?.name,
            artistName = it!!.attributes?.artistName,
            imageUrl = it.attributes?.artwork?.url!!.replace("{w}", "300").replace("{h}", "300"),
        )
    }
}
package jp.co.faith.playlog_android.data.network.search

import com.squareup.moshi.Json
import io.reactivex.Single
import jp.co.faith.playlog_android.common.Const
import jp.co.faith.playlog_android.data.network.BaseDataManager
import retrofit2.Response
import retrofit2.http.*

interface ApplemusicService {
    @GET(Const.Search.API_APPLE)
    fun executeGetLibraryUsage(
        @Query("term") term: String,
        @Query("types") types: String,
    ): Single<SearchResult>
}

class AppleMusicRemote() : BaseDataManager() {
    fun execGetAppleMusicLibrary(term: String): Single<SearchResult> {
        return connector<ApplemusicService>().executeGetLibraryUsage(term,"albums")
    }
}

data class SearchResult(
    @Json(name = "result") val results: Result
)

data class Result(
    @Json(name = "albums") val albums: Resource?,
    @Json(name = "meta") val meta: String?
)

data class Resource(
    @Json(name = "data") val songs: List<Album>?
)

data class Album(
    @Json(name = "id") val id: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "href") val href: String?,
    @Json(name = "attributes") val attributes: Attributes?
)

data class Attributes(
    @Json(name = "copyright") val copyright: String?,
    @Json(name = "genreNames") val songenreNamesgs: List<String>?,
    @Json(name = "releaseDate") val releaseDate: String?,
    @Json(name = "upc") val upc: String?,
    @Json(name = "isMasteredForItunes") val isMasteredForItunes: Boolean?,
    @Json(name = "artwork") val artwork: Artwork?,
    @Json(name = "url") val url: String?,
    @Json(name = "playParams") val playParams: PlayParams?,
    @Json(name = "recordLabel") val recordLabel: String?,
    @Json(name = "trackCount") val trackCount: Int?,
    @Json(name = "isCompilation") val isCompilation: Boolean?,
    @Json(name = "isSingle") val isSingle: Boolean?,
    @Json(name = "name") val name: String?,
    @Json(name = "artistName") val artistName: String?,
    @Json(name = "isComplete") val isComplete: Boolean?
)

data class Artwork(
    @Json(name = "width") val width: Int?,
    @Json(name = "height") val height: Int?,
    @Json(name = "url") val url: String?,
    @Json(name = "bgColor") val bgColor: String?,
    @Json(name = "textColor1") val textColor1: String?,
    @Json(name = "textColor2") val textColor2: String?,
    @Json(name = "textColor3") val textColor3: String?,
    @Json(name = "textColor4") val textColor4: String?
)

data class PlayParams(
    @Json(name = "id") val id: String?,
    @Json(name = "kind") val kind: String?
)
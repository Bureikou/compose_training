package jp.co.faith.playlog_android.data.remote.spotify.search

import jp.co.faith.playlog_android.common.Constants
import jp.co.faith.playlog_android.data.remote.apple.SearchAppleResultDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ShopifySearchApi {
    @Headers("Authorization: Client-ID ${Constants.Token.APPLE_DEV_TOKEN}")
    @GET("v1/catalog/jp/search")
    suspend fun searchAlbums(@Query("term") term: String, @Query("types") types: String, @Query("limit") limit: String) : SearchAppleResultDto
}
package jp.co.faith.playlog_android.data.remote.apple

import jp.co.faith.playlog_android.common.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface AppleApi {
    @Headers("Authorization: Client-ID ${Constants.Token.APPLE_DEV_TOKEN}")
    @GET("v1/catalog/jp/search")
    suspend fun searchAlbums(@Query("term") term: String, @Query("types") types: String, @Query("limit") limit: String) : SearchAppleResultDto

    @Headers("Authorization: Client-ID ${Constants.Token.APPLE_DEV_TOKEN}")
    @GET("photos/{id}")
    suspend fun searchAlbumsById(@Path("id") query: String) : SearchAppleResultDto
}
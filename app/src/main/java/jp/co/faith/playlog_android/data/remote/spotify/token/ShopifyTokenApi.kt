package jp.co.faith.playlog_android.data.remote.spotify.token

import jp.co.faith.playlog_android.common.Constants
import jp.co.faith.playlog_android.data.remote.apple.SearchAppleResultDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ShopifyTokenApi {
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("api/token")
    suspend fun getToken(@Body request: TokenRequest) : GetShopifyApiTokenDto

//    @Headers("Authorization: Client-ID ${Constants.Token.APPLE_DEV_TOKEN}")
//    @GET("photos/{id}")
//    suspend fun searchAlbumsById(@Path("id") query: String) : SearchAppleResultDto
}
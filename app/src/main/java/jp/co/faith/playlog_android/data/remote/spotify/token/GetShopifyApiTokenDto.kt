package jp.co.faith.playlog_android.data.remote.spotify.token


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import jp.co.faith.playlog_android.data.remote.apple.SearchAppleResultDto
import jp.co.faith.playlog_android.domain.model.AppleAlbum
import jp.co.faith.playlog_android.domain.model.ShopifyToken

@JsonClass(generateAdapter = true)
data class GetShopifyApiTokenDto(
    @Json(name = "access_token")
    val accessToken: String?,
    @Json(name = "expires_in")
    val expiresIn: Int?,
    @Json(name = "token_type")
    val tokenType: String?
)

fun GetShopifyApiTokenDto.toToken(): ShopifyToken {
    return ShopifyToken(
        token = accessToken,
    )
}
package jp.co.faith.playlog_android.data.repository

import jp.co.faith.playlog_android.data.remote.apple.AppleApi
import jp.co.faith.playlog_android.data.remote.apple.SearchAppleResultDto
import jp.co.faith.playlog_android.data.remote.spotify.token.GetShopifyApiTokenDto
import jp.co.faith.playlog_android.data.remote.spotify.token.ShopifyTokenApi
import jp.co.faith.playlog_android.data.remote.spotify.token.TokenRequest
import jp.co.faith.playlog_android.domain.repository.AppleRepository
import jp.co.faith.playlog_android.domain.repository.ShopifyRepository
import javax.inject.Inject

class ShopifyRepositoryImpl @Inject constructor(
    private val api: ShopifyTokenApi,
) : ShopifyRepository {
    override suspend fun getShopifyToken(): GetShopifyApiTokenDto {
        val grantType = "client_credentials"
        val clientId = "55999ef0a2394963bccbc8fea5452685"
        val clientSecret = "46d1967d01ce4654ba3a1a4558f0035d"
        val tokenRequest = TokenRequest(grantType, clientId, clientSecret)
        return api.getToken(tokenRequest)
    }

}
package jp.co.faith.playlog_android.domain.repository

import jp.co.faith.playlog_android.data.remote.apple.SearchAppleResultDto
import jp.co.faith.playlog_android.data.remote.spotify.token.GetShopifyApiTokenDto

interface ShopifyRepository {
//    suspend fun searchSpotify(term: String, types: String): SearchAppleResultDto
    suspend fun getShopifyToken(): GetShopifyApiTokenDto
}
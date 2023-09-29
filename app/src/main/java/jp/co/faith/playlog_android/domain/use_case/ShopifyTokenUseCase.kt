package jp.co.faith.playlog_android.domain.use_case

import jp.co.faith.playlog_android.common.NetworkResponse
import jp.co.faith.playlog_android.data.remote.apple.toAlbums
import jp.co.faith.playlog_android.data.remote.spotify.token.toToken
import jp.co.faith.playlog_android.domain.model.AppleAlbum
import jp.co.faith.playlog_android.domain.model.ShopifyToken
import jp.co.faith.playlog_android.domain.repository.AppleRepository
import jp.co.faith.playlog_android.domain.repository.ShopifyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class ShopifyTokenUseCase @Inject constructor(
    private  val repository: ShopifyRepository,
) {
    operator fun invoke(): Flow<NetworkResponse<ShopifyToken>> = flow {
        try {
            emit(NetworkResponse.Loading<ShopifyToken>())
            val token = repository.getShopifyToken().toToken()
            emit(NetworkResponse.Success<ShopifyToken>(token))
        } catch (e: Exception) {
            emit(NetworkResponse.Failure<ShopifyToken>(e.message.toString()))
        }

    }
}
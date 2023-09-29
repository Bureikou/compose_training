package jp.co.faith.playlog_android.domain.use_case

import jp.co.faith.playlog_android.common.NetworkResponse
import jp.co.faith.playlog_android.data.remote.apple.toAlbums
import jp.co.faith.playlog_android.domain.model.AppleAlbum
import jp.co.faith.playlog_android.domain.repository.AppleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class SearchShopifyUseCase @Inject constructor(
    private  val repository: AppleRepository,
) {
    operator fun invoke(term: String): Flow<NetworkResponse<List<AppleAlbum>>> = flow {
        try {
            emit(NetworkResponse.Loading<List<AppleAlbum>>())
            val albums = repository.searchApple(term, "albums").toAlbums()
            emit(NetworkResponse.Success<List<AppleAlbum>>(albums))
        } catch (e: Exception) {
            emit(NetworkResponse.Failure<List<AppleAlbum>>(e.message.toString()))
        }

    }
}
package jp.co.faith.playlog_android.data.repository

import jp.co.faith.playlog_android.data.remote.apple.AppleApi
import jp.co.faith.playlog_android.data.remote.apple.SearchAppleResultDto
import jp.co.faith.playlog_android.domain.repository.AppleRepository
import javax.inject.Inject

class AppleRepositoryImpl @Inject constructor(
    private val api: AppleApi,
) : AppleRepository {
    override suspend fun searchApple(term: String, types: String): SearchAppleResultDto {
        return api.searchAlbums(term, types, "25")
    }

    override suspend fun getAppleById(albumId: String): SearchAppleResultDto {
        return api.searchAlbumsById(albumId)
    }
}
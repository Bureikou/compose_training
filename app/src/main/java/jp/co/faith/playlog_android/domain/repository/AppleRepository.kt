package jp.co.faith.playlog_android.domain.repository

import jp.co.faith.playlog_android.data.remote.apple.SearchAppleResultDto

interface AppleRepository {
    suspend fun searchApple(term: String, types: String): SearchAppleResultDto
    suspend fun getAppleById(albumId: String): SearchAppleResultDto
}
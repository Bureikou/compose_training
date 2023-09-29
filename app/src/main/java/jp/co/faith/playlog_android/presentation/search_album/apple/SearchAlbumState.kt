package jp.co.faith.playlog_android.presentation.search_album.apple

import jp.co.faith.playlog_android.domain.model.AppleAlbum

data class SearchAlbumState(
    val isLoading: Boolean = false,
    val albums: List<AppleAlbum> = emptyList(),
    val error: String? = null,
)

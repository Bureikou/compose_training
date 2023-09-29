package jp.co.faith.playlog_android.presentation.search_album.shopify

import jp.co.faith.playlog_android.domain.model.AppleAlbum

data class SearchShopifyAlbumState(
    val isLoading: Boolean = false,
    val albums: List<AppleAlbum> = emptyList(),
    val error: String? = null,
)

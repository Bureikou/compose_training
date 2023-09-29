package jp.co.faith.playlog_android.presentation.search_album.shopify

import jp.co.faith.playlog_android.domain.model.ShopifyToken

data class GetShopifyTokenState(
    val isLoading: Boolean = false,
    val token: String = "",
    val error: String? = null,
)


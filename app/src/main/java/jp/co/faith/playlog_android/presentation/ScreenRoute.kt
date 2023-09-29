package jp.co.faith.playlog_android.presentation

sealed class ScreenRoute(val route:String) {
    object SearchAlbumScreen : ScreenRoute("search_album_screen")
    object SearchShopifyAlbumScreen : ScreenRoute("search_album_screen")
}

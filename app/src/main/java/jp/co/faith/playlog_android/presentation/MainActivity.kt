package jp.co.faith.playlog_android.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.co.faith.playlog_android.MainViewModel
import jp.co.faith.playlog_android.presentation.search_album.apple.SearchAlbumScreen
import jp.co.faith.playlog_android.presentation.search_album.shopify.SearchShopifyAlbumScreen
import jp.co.faith.playlog_android.presentation.ui.theme.Playlog_androidTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Playlog_androidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
//                        startDestination = ScreenRoute.SearchPhotosScreen.route,
                        startDestination = ScreenRoute.SearchAlbumScreen.route + "/{searchWord}", // TODO アルバム検索画面をタブで選択させたい
                    ) {
                        composable(route = ScreenRoute.SearchAlbumScreen.route + "/{searchWord}") {
                            SearchAlbumScreen(navController)
                        }
                        composable(route = ScreenRoute.SearchShopifyAlbumScreen.route + "/{searchWord}") {
                            SearchShopifyAlbumScreen(navController)
                        }
                    }
                }
            }
        }

        // 共有インテントからデータを取得
        val intent = intent
        val action = intent.action
        val type = intent.type

        if (Intent.ACTION_SEND == action && type != null) {
            if ("text/plain" == type) {
                // 共有されたテキストデータを取得
                val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)

                if (sharedText != null) {
                    // TODO 取得したurlを使って楽曲を取得する
                    // <apple music>
                    // https://music.apple.com/jp/album/%E6%9D%B1%E4%BA%AC/1607227005?ls
                    // --> https://api.music.apple.com/v1/catalog/jp/albums/1607227005
                    // <spotify>
                    // https://open.spotify.com/track/6gEdgXFq7L8xkmrTvSt1OX?si=0o-qAaPFQAqSr44rwgQebw
                    // -- >
                    Log.d("API_CHECK", sharedText)
                }
            }
        }

    }
}

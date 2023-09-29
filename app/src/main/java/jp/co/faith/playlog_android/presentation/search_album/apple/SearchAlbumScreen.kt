package jp.co.faith.playlog_android.presentation.search_album.apple

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import jp.co.faith.playlog_android.presentation.ScreenRoute
import jp.co.faith.playlog_android.presentation.components.SearchBar
import jp.co.faith.playlog_android.presentation.search_album.components.AppleAlbumThumbnail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAlbumScreen(
    navController: NavController,
    viewModel: SearchAlbumViewModel = hiltViewModel(),
)
{
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            SearchBar(
                searchText = viewModel.query,
                onSearchTextChanged = { viewModel.query = it },
                onDone = { viewModel.searchAlbums() },
            )
        }
    ) { paddingValue ->
        Box(modifier = Modifier.fillMaxSize()) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                !state.error.isNullOrBlank() -> {
                    // error
                    Text(
                        text = state.error,
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error,
                    )
                }
                else -> {
                    LazyColumn(modifier = Modifier.padding(paddingValue))
                    {
                        items(state.albums) { album ->
                            AppleAlbumThumbnail(
                                appleAlbum = album,
                                onClick = {
                                    /// TODO
                                })
                        }
                    }
                }
            }
        }
    }
}

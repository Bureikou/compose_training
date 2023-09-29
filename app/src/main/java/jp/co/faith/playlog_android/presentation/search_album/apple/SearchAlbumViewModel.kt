package jp.co.faith.playlog_android.presentation.search_album.apple

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.faith.playlog_android.common.NetworkResponse
import jp.co.faith.playlog_android.domain.use_case.SearchAppleUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchAlbumViewModel @Inject constructor(
    private val searchAlbumUseCase: SearchAppleUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = mutableStateOf(SearchAlbumState())
    val state: State<SearchAlbumState> = _state

    var query by mutableStateOf("")

    init {
//        searchAlbums()
    }

    fun searchAlbums() {
        searchAlbumUseCase(query).onEach { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    _state.value = SearchAlbumState(
                        isLoading = false,
                        albums = result.data ?: emptyList(),
                    )
                }
                is NetworkResponse.Failure -> {
                    _state.value = SearchAlbumState(error = result.error)
                }
                is NetworkResponse.Loading -> {
                    _state.value = SearchAlbumState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
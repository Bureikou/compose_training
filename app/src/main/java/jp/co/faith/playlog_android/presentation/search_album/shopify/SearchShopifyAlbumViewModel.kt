package jp.co.faith.playlog_android.presentation.search_album.shopify

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.faith.playlog_android.common.NetworkResponse
import jp.co.faith.playlog_android.domain.use_case.SearchShopifyUseCase
import jp.co.faith.playlog_android.domain.use_case.ShopifyTokenUseCase
import jp.co.faith.playlog_android.presentation.search_album.apple.SearchAlbumState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchShopifyAlbumViewModel @Inject constructor(
    private val shopifyTokenUseCase: ShopifyTokenUseCase,
    private val searchShopifyUseCase: SearchShopifyUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = mutableStateOf(GetShopifyTokenState())
    val state: State<GetShopifyTokenState> = _state

    private val _searchState = mutableStateOf(SearchShopifyAlbumState())
    val searchState: State<SearchShopifyAlbumState> = _searchState

    var query by mutableStateOf("")

    init {
        getToken()
    }

    fun getToken() {
        shopifyTokenUseCase().onEach { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    _state.value = GetShopifyTokenState(
                        isLoading = false,
                        token = result.data?.token ?: "",
                    )
                }
                is NetworkResponse.Failure -> {
                    _state.value = GetShopifyTokenState(error = result.error)
                }
                is NetworkResponse.Loading -> {
                    _state.value = GetShopifyTokenState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun searchAlbums() {
        searchShopifyUseCase(query).onEach { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    _searchState.value = SearchShopifyAlbumState(
                        isLoading = false,
                        albums = result.data ?: emptyList(),
                    )
                }
                is NetworkResponse.Failure -> {
                    _searchState.value = SearchShopifyAlbumState(error = result.error)
                }
                is NetworkResponse.Loading -> {
                    _searchState.value = SearchShopifyAlbumState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
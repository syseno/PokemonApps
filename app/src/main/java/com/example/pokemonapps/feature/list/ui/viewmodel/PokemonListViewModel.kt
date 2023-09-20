package com.example.pokemonapps.feature.list.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foundation.ViewState
import com.example.local.provider.AppDatabase
import com.example.pokemonapps.feature.detail.ui.model.UIPokemonDetail
import com.example.pokemonapps.feature.list.data.repository.PokemonListRepository
import com.example.remote.models.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonListRepository: PokemonListRepository,
    private val appDatabase: AppDatabase
) : ViewModel() {
    val getPokemonList = pokemonListRepository.getPokemonList()

    val pokemonDetailState =
        MutableStateFlow<ViewState<UIPokemonDetail>>(ViewState.Loading(true))

    fun getPokemonDetail(pokemonId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonListRepository.getPokemonDetail(pokemonId).collectLatest { apiResult ->
                when (apiResult) {
                    is ApiResult.Loading -> {
                        pokemonDetailState.value = (ViewState.Loading(true))
                    }

                    is ApiResult.Success -> {
                        pokemonDetailState.value = (ViewState.Success(apiResult.data))
                    }

                    is ApiResult.Error -> {
                        pokemonDetailState.value = (ViewState.Failure(apiResult.throwable))
                    }
                }
            }
        }
    }
}
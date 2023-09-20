package com.example.pokemonapps.feature.detail.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foundation.ViewState
import com.example.pokemonapps.feature.detail.ui.model.UIPokemonDetail
import kotlinx.coroutines.flow.MutableStateFlow

class PokemonDetailViewModel: ViewModel() {

    val pokemonDetailState =
        MutableStateFlow<ViewState<UIPokemonDetail>>(ViewState.Loading(true))

    fun getPokemonDetail(pokemonId: String) {

    }
}
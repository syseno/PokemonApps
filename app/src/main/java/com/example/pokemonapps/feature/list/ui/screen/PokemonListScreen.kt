package com.example.pokemonapps.feature.list.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.foundation.views.ErrorItem
import com.example.foundation.views.LoadingItem
import com.example.foundation.views.LoadingView
import com.example.pokemonapps.feature.list.ui.model.UIPokemon
import com.example.pokemonapps.feature.list.ui.viewmodel.PokemonListViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun PokemonListScreen(viewModel: PokemonListViewModel, navHostController: NavHostController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(bottom = paddingValues.calculateBottomPadding())
        )
        { PokemonList(pokemons = viewModel.getPokemonList, navHostController) }
    }
}

@Composable
fun PokemonList(pokemons: Flow<PagingData<UIPokemon>>, navHostController: NavHostController) {
    val lazyPokemonItems = pokemons.collectAsLazyPagingItems()

    LazyColumn {

        items(lazyPokemonItems) { pokemon ->
            PokemonItem(pokemon = pokemon!!, navHostController)
        }

        lazyPokemonItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }

                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }

                loadState.refresh is LoadState.Error -> {
                    val e = lazyPokemonItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }

                loadState.append is LoadState.Error -> {
                    val e = lazyPokemonItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}
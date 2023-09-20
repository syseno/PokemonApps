package com.example.pokemonapps.navigation

import PokemonDetailScreen
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokemonapps.feature.list.ui.screen.PokemonListScreen
import com.example.pokemonapps.feature.list.ui.viewmodel.PokemonListViewModel

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun NavGraph(
    navController: NavHostController, viewModel: PokemonListViewModel
) {
    NavHost(navController = navController, startDestination = Route.Home.route) {
        composable(route = Route.Home.route) {
            PokemonListScreen(viewModel = viewModel, navController)
        }
        composable(route = Route.Detail.route + "/{id}") { navBackStack ->
            val id = navBackStack.arguments?.getString("id")
            PokemonDetailScreen(viewModel = viewModel, id.toString())
        }
    }
}
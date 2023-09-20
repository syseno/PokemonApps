package com.example.pokemonapps

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pokemonapps.feature.list.ui.viewmodel.PokemonListViewModel
import com.example.pokemonapps.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonActivity: ComponentActivity() {
    private val viewModel: PokemonListViewModel by viewModels()
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            ShowToolbar(viewModel)
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun ShowToolbar(viewModel: PokemonListViewModel) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = getString(R.string.app_name))
                }, navigationIcon = {
                })
            },
        ) {
            NavGraph(
                navController = navController,
                viewModel
            )
        }
    }
}
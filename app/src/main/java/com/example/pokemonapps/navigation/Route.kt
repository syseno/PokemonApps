package com.example.pokemonapps.navigation

import com.example.pokemonapps.navigation.Const.POKEMON_DETAIL_SCREEN
import com.example.pokemonapps.navigation.Const.POKEMON_LIST_SCREEN

sealed class Route(val route: String) {
    data object Home : Route(POKEMON_LIST_SCREEN)
    data object Detail : Route(POKEMON_DETAIL_SCREEN)
}

object Const {
    //Screens
    const val POKEMON_LIST_SCREEN = "pokemon_list"
    const val POKEMON_DETAIL_SCREEN = "pokemon_detail"
}
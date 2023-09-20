package com.example.pokemonapps.feature.detail.ui.model

data class UIPokemonDetail(
    val id: Int,
    val name: String,
    val urlImage: String,
    val height: Int,
    val weight: Int,
    val moves: List<String>,
    val types: List<String>
)

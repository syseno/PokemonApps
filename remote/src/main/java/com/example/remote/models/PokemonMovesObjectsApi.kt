package com.example.remote.models

import com.google.gson.annotations.SerializedName

data class PokemonMovesObjectsApi(
    @SerializedName("move")
    val move: PokemonMoveApi
)

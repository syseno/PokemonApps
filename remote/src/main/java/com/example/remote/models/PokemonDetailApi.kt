package com.example.remote.models

import com.google.gson.annotations.SerializedName

data class PokemonDetailApi(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("height")
    var height: Int = 0,

    @SerializedName("weight")
    var weight: Int = 0,

    @SerializedName("moves")
    var moves: List<PokemonMovesObjectsApi> = emptyList(),

    @SerializedName("types")
    var types: List<PokemonTypesObjectApi> = emptyList()
)
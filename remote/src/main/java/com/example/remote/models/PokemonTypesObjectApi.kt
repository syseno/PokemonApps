package com.example.remote.models

import com.google.gson.annotations.SerializedName

data class PokemonTypesObjectApi(
    @SerializedName("type")
    val type: PokemonTypeApi
)

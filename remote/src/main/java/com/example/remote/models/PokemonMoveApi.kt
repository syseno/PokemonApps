package com.example.remote.models

import com.google.gson.annotations.SerializedName

class PokemonMoveApi(
    @SerializedName("name")
    val name: String
)
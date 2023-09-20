package com.example.remote.services

import com.example.remote.models.PokemonDetailApi
import com.example.remote.models.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiServices {
    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Response<PokemonResponse>

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(@Path("name") name: String): Response<PokemonDetailApi>
}
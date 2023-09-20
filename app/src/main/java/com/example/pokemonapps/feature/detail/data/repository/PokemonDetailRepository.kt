package com.example.pokemonapps.feature.detail.data.repository

import androidx.room.withTransaction
import com.example.local.provider.AppDatabase
import com.example.pokemonapps.feature.detail.data.mapper.PokemonDetailApiToPokemonDetailEntityMapper
import com.example.pokemonapps.feature.detail.data.mapper.PokemonDetailApiToUIPokemonDetailMapper
import com.example.pokemonapps.feature.detail.ui.model.UIPokemonDetail
import com.example.remote.models.ApiResult
import com.example.remote.services.PokeApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PokemonDetailRepository @Inject constructor(
    private val pokemonServices: PokeApiServices,
    private val appDataBase: AppDatabase
) {
    fun getPokemonDetail(pokemonId: String): Flow<ApiResult<UIPokemonDetail>> {
        return flow {
            try {
                emit(ApiResult.Loading)

                val response = pokemonServices.fetchPokemonInfo(pokemonId)
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    emit(ApiResult.Success(PokemonDetailApiToUIPokemonDetailMapper().invoke(body)))
                } else {
                    throw HttpException(response)
                }

            } catch (io: IOException) {
                emit(ApiResult.Error(io))
            } catch (http: HttpException) {
                emit(ApiResult.Error(http))
            }
        }
    }

    suspend fun saveMyPokemon(pokemon: UIPokemonDetail) {
        appDataBase.withTransaction {

        }
    }
}
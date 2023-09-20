package com.example.pokemonapps.feature.list.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.room.withTransaction
import com.example.local.provider.AppDatabase
import com.example.pokemonapps.feature.detail.data.mapper.PokemonDetailApiToUIPokemonDetailMapper
import com.example.pokemonapps.feature.detail.ui.model.UIPokemonDetail
import com.example.pokemonapps.feature.list.data.repository.paging.PokemonPaging
import com.example.pokemonapps.feature.list.ui.model.UIPokemon
import com.example.remote.models.ApiResult
import com.example.remote.services.PokeApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PokemonListRepository @Inject constructor(
    private val pokemonServices: PokeApiServices,
    private val appDataBase: AppDatabase
) {
    fun getPokemonList(): Flow<PagingData<UIPokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = DEFAULT_PAGE_SIZE,
                enablePlaceholders = DEFAULT_PLACEHOLDER
            ),
            pagingSourceFactory = { PokemonPaging(pokemonServices) },
        ).flow
    }

    fun getPokemonDetail(pokemonId: String): Flow<ApiResult<UIPokemonDetail>> {
        return flow {
            try {
                val response = pokemonServices.fetchPokemonInfo(pokemonId)
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    emit(
                        ApiResult.Success(
                            PokemonDetailApiToUIPokemonDetailMapper().invoke(body)
                        )
                    )
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


    fun getMyPokemonList() {

    }


    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
        private const val DEFAULT_PLACEHOLDER = false
    }
}
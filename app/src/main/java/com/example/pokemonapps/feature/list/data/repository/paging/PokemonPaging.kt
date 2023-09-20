package com.example.pokemonapps.feature.list.data.repository.paging

import android.annotation.SuppressLint
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokemonapps.feature.list.data.mapper.PokemonApiToUIPokemonMapper
import com.example.pokemonapps.feature.list.ui.model.UIPokemon
import com.example.remote.models.PokemonApi
import com.example.remote.services.PokeApiServices
import java.io.IOException

@SuppressLint("NewApi")
class PokemonPaging(
    private val pokeApiServices: PokeApiServices
) : PagingSource<Int, UIPokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UIPokemon> {
        val offset = params.key ?: STARTING_OFFSET_INDEX

        val loadSize = params.loadSize
        return try {
            val data = pokeApiServices.fetchPokemonList(loadSize, offset)

            LoadResult.Page(
                data = data.body()?.results.orEmpty().map {
                    PokemonApiToUIPokemonMapper().invoke(it)
                },
                prevKey = if (offset == STARTING_OFFSET_INDEX) null else offset - loadSize,
                nextKey = if (data.body()?.next == null) null else offset + loadSize
            )
        } catch (t: Throwable) {
            var exception = t

            if (t is IOException) {
                exception = IOException("Please check internet connection")
            }
            LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, UIPokemon>): Int? {
        return state.anchorPosition
    }


    companion object {
        const val STARTING_OFFSET_INDEX = 0
    }

}
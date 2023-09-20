package com.example.pokemonapps.feature.detail.data.mapper

import com.example.foundation.mapper.Mapper
import com.example.local.entities.PokemonDetailEntity
import com.example.pokemonapps.feature.detail.ui.model.UIPokemonDetail
import com.example.remote.models.PokemonDetailApi

class PokemonDetailApiToUIPokemonDetailMapper : Mapper<PokemonDetailApi, UIPokemonDetail> {
    override fun invoke(param: PokemonDetailApi): UIPokemonDetail {
        return UIPokemonDetail(
            id = param.id,
            name = param.name,
            height = param.height,
            weight = param.weight,
            moves = param.moves.map {
                it.move.name
            },
            types = param.types.map {
                it.type.name
            },
            urlImage = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${param.id}.png"
        )
    }
}
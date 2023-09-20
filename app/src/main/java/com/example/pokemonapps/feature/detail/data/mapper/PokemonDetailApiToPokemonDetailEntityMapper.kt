package com.example.pokemonapps.feature.detail.data.mapper

import com.example.foundation.mapper.Mapper
import com.example.local.entities.PokemonDetailEntity
import com.example.remote.models.PokemonDetailApi

class PokemonDetailApiToPokemonDetailEntityMapper : Mapper<PokemonDetailApi, PokemonDetailEntity> {
    override fun invoke(param: PokemonDetailApi): PokemonDetailEntity {
        return PokemonDetailEntity(
            id = param.id,
            name = param.name,
            height = param.height,
            weight = param.weight,
            moves = param.moves.map {
                it.move.name
            },
            types = param.types.map {
                it.type.name
            }
        )
    }
}
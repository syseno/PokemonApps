package com.example.pokemonapps.feature.list.data.mapper

import com.example.foundation.mapper.Mapper
import com.example.local.entities.PokemonEntity
import com.example.remote.models.PokemonApi

class PokemonApiToPokemonEntityMapper : Mapper<PokemonApi, PokemonEntity> {
    override fun invoke(param: PokemonApi): PokemonEntity {
        return PokemonEntity(
            id = param.url.split("/".toRegex()).dropLast(1).last().toInt(),
            name = param.name
        )
    }
}
package com.example.pokemonapps.feature.list.data.mapper

import com.example.foundation.mapper.Mapper
import com.example.local.entities.PokemonEntity
import com.example.pokemonapps.feature.list.ui.model.UIPokemon
import com.example.remote.models.PokemonApi

class PokemonApiToUIPokemonMapper : Mapper<PokemonApi, UIPokemon> {
    override fun invoke(param: PokemonApi): UIPokemon {
        return UIPokemon(
            id = param.url.substringAfter("pokemon").replace("/", "").toInt(),
            name = param.name,
            urlImage = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${
                param.url.substringAfter(
                    "pokemon"
                ).replace("/", "").toInt()
            }.png"
        )
    }
}
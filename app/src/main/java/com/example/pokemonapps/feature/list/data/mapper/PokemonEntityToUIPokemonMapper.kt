package com.example.pokemonapps.feature.list.data.mapper

import com.example.foundation.mapper.Mapper
import com.example.local.entities.PokemonEntity
import com.example.pokemonapps.feature.list.ui.model.UIPokemon

class PokemonEntityToUIPokemonMapper : Mapper<PokemonEntity, UIPokemon> {
    override fun invoke(param: PokemonEntity): UIPokemon {
        return UIPokemon(
            id = param.id,
            name = param.name,
            urlImage = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${param.id}.png"
        )
    }
}
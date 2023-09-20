package com.example.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.local.entities.PokemonEntity.Companion.POKEMON_TABLE

@Entity(tableName = POKEMON_TABLE)
data class PokemonEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String
) {
    companion object {
        const val POKEMON_TABLE = "pokemon"
    }
}

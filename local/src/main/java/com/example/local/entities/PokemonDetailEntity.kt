package com.example.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.local.entities.PokemonDetailEntity.Companion.POKEMON_DETAIL_TABLE

@Entity(tableName = POKEMON_DETAIL_TABLE)
data class PokemonDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "height")
    val height: Int,
    @ColumnInfo(name = "weight")
    val weight: Int,
    @ColumnInfo(name = "moves")
    val moves: List<String>,
    @ColumnInfo(name = "types")
    val types: List<String>
) {
    companion object {
        const val POKEMON_DETAIL_TABLE = "pokemon_detail"
    }
}
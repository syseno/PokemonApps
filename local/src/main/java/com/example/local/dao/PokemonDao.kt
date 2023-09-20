package com.example.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.local.entities.PokemonDetailEntity
import com.example.local.entities.PokemonDetailEntity.Companion.POKEMON_DETAIL_TABLE
import com.example.local.entities.PokemonEntity
import com.example.local.entities.PokemonEntity.Companion.POKEMON_TABLE

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdatePokemonDetail(entity: PokemonDetailEntity)

    @Query("SELECT * FROM $POKEMON_DETAIL_TABLE WHERE id = :id")
    fun getPokemonDetail(id: Int): PokemonDetailEntity

    @Query("DELETE FROM $POKEMON_DETAIL_TABLE")
    fun deletePokemonDetail()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdatePokemon(entities: ArrayList<PokemonEntity>)

    @Query("SELECT * FROM $POKEMON_TABLE")
    fun getAllPokemon(): PagingSource<Int, PokemonEntity>

    @Query("DELETE FROM $POKEMON_TABLE")
    fun deletePokemon()
}
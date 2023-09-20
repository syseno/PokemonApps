package com.example.local.provider

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.local.dao.PokemonDao
import com.example.local.dao.RemoteKeyDao
import com.example.local.entities.PokemonDetailEntity
import com.example.local.entities.PokemonEntity
import com.example.local.entities.RemoteKeys

@Database(
    entities = [
        PokemonEntity::class,
        PokemonDetailEntity::class,
        RemoteKeys::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
    abstract fun remoteKeyDao(): RemoteKeyDao

}
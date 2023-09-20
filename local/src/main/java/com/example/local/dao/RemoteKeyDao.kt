package com.example.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.local.entities.RemoteKeys

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("Select * From remote_key Where pokemonId = :id")
    fun getRemoteKeyByPokemonId(id: Int): RemoteKeys?

    @Query("Delete From remote_key")
    fun clearRemoteKeys()
}
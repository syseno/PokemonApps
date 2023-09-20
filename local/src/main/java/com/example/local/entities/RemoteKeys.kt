package com.example.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_key")
data class RemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val pokemonId: Int,
    val prevKey:Int?,
    val nextKey:Int?
)

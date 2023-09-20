package com.example.local.di

import android.app.Application
import androidx.room.Room
import com.example.local.dao.PokemonDao
import com.example.local.dao.RemoteKeyDao
import com.example.local.provider.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun providePokemonDao(appDatabase: AppDatabase): PokemonDao = appDatabase.pokemonDao()

    @Provides
    fun provideRemoteKeyDao(appDatabase: AppDatabase): RemoteKeyDao = appDatabase.remoteKeyDao()

    @Singleton
    @Provides
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "pokemon.db")
            .fallbackToDestructiveMigration()
            .build()
}
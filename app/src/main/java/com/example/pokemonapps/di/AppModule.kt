package com.example.pokemonapps.di

import com.example.local.provider.AppDatabase
import com.example.pokemonapps.feature.list.data.repository.PokemonListRepository
import com.example.remote.services.PokeApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCurrencyRepository(
        pokemonServices: PokeApiServices,
        appDataBase: AppDatabase
    ): PokemonListRepository = PokemonListRepository(
        pokemonServices,
        appDataBase
    )
}
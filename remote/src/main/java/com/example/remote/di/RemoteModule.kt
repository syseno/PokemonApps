package com.example.remote.di

import com.example.remote.const.RemoteEnv
import com.example.remote.services.PokeApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun provideRetrofit(): PokeApiServices {
        return Retrofit.Builder()
            .baseUrl(RemoteEnv.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApiServices::class.java)
    }
}
package com.akin.leagueoflegends.di

import com.akin.leagueoflegends.data.api.RetrofitService
import com.akin.leagueoflegends.util.Statics.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaeUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(): RetrofitService =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)

}
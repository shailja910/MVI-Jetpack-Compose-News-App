package com.example.mvi_jetpackcompose_newsapp.di.networkmodule

import com.example.mvi_newsapp_jetpackcompose.core.network.C_RetrofitAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
@Module: Marks this object as a Dagger/Hilt module, a container for providing dependencies.
@InstallIn(SingletonComponent::class): Specifies the lifecycle scope of the provided dependencies.
SingletonComponent means these dependencies live as long as the whole app (singletons).*/

@Module
@InstallIn(SingletonComponent::class)
object B_RetrofitInstance {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())  // JSON parsing support
            .build()
    }


        @Provides
        fun provideMyService(retrofit: Retrofit): C_RetrofitAPI {
            return retrofit.create(C_RetrofitAPI::class.java)
        }
}
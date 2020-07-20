package com.example.mvvmcleanarchitecture.core.di

import com.example.mvvmcleanarchitecture.BuildConfig
import com.example.mvvmcleanarchitecture.features.data.RickAndMortyApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<Interceptor> { provideHttpLoggingInterceptor() }

    single { provideOkHttpClient(get()) }

    single { provideRetrofit(get()) }

    single { provideRickAndMortyApi(get()) }
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = when (BuildConfig.DEBUG) {
            true -> HttpLoggingInterceptor.Level.BODY
            false -> HttpLoggingInterceptor.Level.NONE
        }
    }
}

private fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .build()
}

private const val BASE_URL = "https://rickandmortyapi.com/api/"

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

private fun provideRickAndMortyApi(retrofit: Retrofit): RickAndMortyApi {
    return retrofit.create(RickAndMortyApi::class.java)
}
package com.example.mvvmcleanarchitecture.core.api

import com.example.mvvmcleanarchitecture.core.api.model.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("episodes")
    suspend fun getEpisodes(): EpisodesResponse
}
package com.example.mvvmcleanarchitecture.core.api

import com.example.mvvmcleanarchitecture.core.api.model.EpisodesResponse
import com.example.mvvmcleanarchitecture.core.api.model.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse
}
package com.example.mvvmcleanarchitecture.features.locations.domain

import com.example.mvvmcleanarchitecture.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}
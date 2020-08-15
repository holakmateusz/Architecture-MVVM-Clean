package com.example.mvvmcleanarchitecture.features.locations.domain

import com.example.mvvmcleanarchitecture.core.base.UseCase
import com.example.mvvmcleanarchitecture.features.locations.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocations()
}
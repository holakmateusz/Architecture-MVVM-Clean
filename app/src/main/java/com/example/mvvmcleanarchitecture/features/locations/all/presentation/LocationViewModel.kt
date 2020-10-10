package com.example.mvvmcleanarchitecture.features.locations.all.presentation

import androidx.lifecycle.*
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.core.exception.ErrorMapper
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import com.example.mvvmcleanarchitecture.features.locations.domain.GetLocationsUseCase
import com.example.mvvmcleanarchitecture.features.locations.domain.model.Location
import com.example.mvvmcleanarchitecture.features.locations.navigation.LocationNavigator

class LocationViewModel(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val locationNavigator: LocationNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper),
    DefaultLifecycleObserver {
    private val _locations by lazy {
        MutableLiveData<List<Location>>().also {
            getLocations(it)
        }
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { locations ->
            locations.map { LocationDisplayable(it) }
        }
    }

    private fun getLocations(locationsLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationsUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locationsLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    internal fun onLocationClick(location: LocationDisplayable) {
        locationNavigator.openLocationDetailsScreen(location)
    }
}
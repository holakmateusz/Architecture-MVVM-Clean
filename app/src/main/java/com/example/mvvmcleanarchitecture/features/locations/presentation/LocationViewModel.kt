package com.example.mvvmcleanarchitecture.features.locations.presentation

import androidx.lifecycle.*
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.core.exception.ErrorMapper
import com.example.mvvmcleanarchitecture.features.locations.domain.GetLocationsUseCase
import com.example.mvvmcleanarchitecture.features.locations.domain.model.Location
import com.example.mvvmcleanarchitecture.features.locations.presentation.model.LocationDisplayable

class LocationViewModel(
    private val getLocationsUseCase: GetLocationsUseCase,
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
}
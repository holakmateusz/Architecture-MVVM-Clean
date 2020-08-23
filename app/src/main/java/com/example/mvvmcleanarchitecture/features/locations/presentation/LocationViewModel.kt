package com.example.mvvmcleanarchitecture.features.locations.presentation

import androidx.lifecycle.*
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.features.locations.domain.GetLocationsUseCase
import com.example.mvvmcleanarchitecture.features.locations.domain.model.Location
import com.example.mvvmcleanarchitecture.features.locations.presentation.model.LocationDisplayable
import kotlinx.coroutines.Dispatchers

class LocationViewModel(private val getLocationsUseCase: GetLocationsUseCase) : BaseViewModel(),
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
            scope = viewModelScope,
            executionDispatcher = Dispatchers.IO
        ) { result ->
            setIdleState()
            result.onSuccess { locationsLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}
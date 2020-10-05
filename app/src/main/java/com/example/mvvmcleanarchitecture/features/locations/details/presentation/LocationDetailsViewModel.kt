package com.example.mvvmcleanarchitecture.features.locations.details.presentation

import androidx.lifecycle.MutableLiveData
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.core.exception.ErrorMapper
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable

class LocationDetailsViewModel(errorMapper: ErrorMapper) : BaseViewModel(errorMapper) {
    private val _location: MutableLiveData<LocationDisplayable> by lazy {
        MutableLiveData<LocationDisplayable>()
    }
    val location: MutableLiveData<LocationDisplayable> by lazy {
        _location
    }

    internal fun setLocation(locationDisplayable: LocationDisplayable) {
        _location.value = locationDisplayable
    }
}
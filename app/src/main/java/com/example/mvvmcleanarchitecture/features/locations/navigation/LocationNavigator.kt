package com.example.mvvmcleanarchitecture.features.locations.navigation

import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}
package com.example.mvvmcleanarchitecture.features.locations.navigation


import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import com.example.mvvmcleanarchitecture.features.locations.details.presentation.LocationDetailsFragment

class LocationNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : LocationNavigator {
    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_locations_screen_to_location_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}
package com.example.mvvmcleanarchitecture.features.locations.navigation

import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import com.example.mvvmcleanarchitecture.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.Test

internal class LocationNavigatorImplTest {
    @Test
    fun `When openLocationDetailsScreen is called THEN invoke navigateTo method with appropriate action and location model as argument `() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val location = LocationDisplayable.mock()
        val slot = slot<Pair<String, LocationDisplayable>>()

        //when
        locationNavigator.openLocationDetailsScreen(location)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_locations_screen_to_location_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe location
    }

    @Test
    fun `When goBack is called THEN invoke goBack method of FragmentNavigator `() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)

        //when
        locationNavigator.goBack()

        //then
        verify { fragmentNavigator.goBack() }
    }
}
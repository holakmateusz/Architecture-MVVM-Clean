package com.example.mvvmcleanarchitecture.features.locations.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.mvvmcleanarchitecture.core.base.UiState
import com.example.mvvmcleanarchitecture.features.locations.domain.GetLocationsUseCase
import com.example.mvvmcleanarchitecture.features.locations.domain.model.Location
import com.example.mvvmcleanarchitecture.mock.mock
import com.example.mvvmcleanarchitecture.utils.ViewModelTest
import com.example.mvvmcleanarchitecture.utils.getOrAwaitValue
import com.example.mvvmcleanarchitecture.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationViewModelTest : ViewModelTest() {
    @Test
    fun `When locations live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `When locations live data is observed THEN invoke use case to get locations`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(viewModel.viewModelScope, Unit, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN location live data is observed THEN set idle state AND set result in live data`() {
        //given
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.id shouldBe location.id
            locationDisplayable.name shouldBe location.name
            locationDisplayable.dimension shouldBe location.dimension
            locationDisplayable.type shouldBe location.type
            locationDisplayable.url shouldBe location.url
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN location live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Oops... Something went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}
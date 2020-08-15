package com.example.mvvmcleanarchitecture.features.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetLocationsUseCaseTest {
    @Test
    fun `when use case is invoked then execute getLocations method from repository`() {
        val repository = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationsUseCase(repository)
        useCase(
            params = Unit,
            scope = GlobalScope
        )
        coVerify {
            repository.getLocations()
        }
    }
}
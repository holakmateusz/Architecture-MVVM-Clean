package com.example.mvvmcleanarchitecture.features.locations.di

import com.example.mvvmcleanarchitecture.features.locations.data.repository.LocationRepositoryImpl
import com.example.mvvmcleanarchitecture.features.locations.domain.GetLocationsUseCase
import com.example.mvvmcleanarchitecture.features.locations.domain.LocationRepository
import com.example.mvvmcleanarchitecture.features.locations.presentation.LocationAdapter
import com.example.mvvmcleanarchitecture.features.locations.presentation.LocationFragment
import com.example.mvvmcleanarchitecture.features.locations.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get()) }
    factory { LocationFragment() }
    factory { LocationAdapter() }
}
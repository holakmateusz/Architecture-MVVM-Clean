package com.example.mvvmcleanarchitecture.features.locations.di

import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.LocationAdapter
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.LocationFragment
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.LocationViewModel
import com.example.mvvmcleanarchitecture.features.locations.data.repository.LocationRepositoryImpl
import com.example.mvvmcleanarchitecture.features.locations.details.presentation.LocationDetailsFragment
import com.example.mvvmcleanarchitecture.features.locations.details.presentation.LocationDetailsViewModel
import com.example.mvvmcleanarchitecture.features.locations.domain.GetLocationsUseCase
import com.example.mvvmcleanarchitecture.features.locations.domain.LocationRepository
import com.example.mvvmcleanarchitecture.features.locations.navigation.LocationNavigator
import com.example.mvvmcleanarchitecture.features.locations.navigation.LocationNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get(), get(), get()) }
    viewModel { LocationDetailsViewModel(get()) }
    factory { LocationFragment() }
    factory { LocationDetailsFragment() }
    factory { LocationAdapter() }
    factory { provideLocationNavigator(get()) }
}

fun provideLocationNavigator(fragmentNavigator: FragmentNavigator): LocationNavigator =
    LocationNavigatorImpl(fragmentNavigator)
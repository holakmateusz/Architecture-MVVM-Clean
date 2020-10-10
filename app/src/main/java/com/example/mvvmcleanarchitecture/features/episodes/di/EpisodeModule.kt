package com.example.mvvmcleanarchitecture.features.episodes.di

import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.EpisodeAdapter
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.EpisodeFragment
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.EpisodeViewModel
import com.example.mvvmcleanarchitecture.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.mvvmcleanarchitecture.features.episodes.details.presentation.EpisodeDetailsFragment
import com.example.mvvmcleanarchitecture.features.episodes.details.presentation.EpisodeDetailsViewModel
import com.example.mvvmcleanarchitecture.features.episodes.domain.EpisodeRepository
import com.example.mvvmcleanarchitecture.features.episodes.domain.GetEpisodesUseCase
import com.example.mvvmcleanarchitecture.features.episodes.navigation.EpisodeNavigator
import com.example.mvvmcleanarchitecture.features.episodes.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get(), get(), get()) }
    viewModel { EpisodeDetailsViewModel() }
    factory { EpisodeFragment() }
    factory { EpisodeDetailsFragment() }
    factory { EpisodeAdapter() }
    factory { provideEpisodeNavigator(get()) }
}

fun provideEpisodeNavigator(fragmentNavigator: FragmentNavigator): EpisodeNavigator =
    EpisodeNavigatorImpl(fragmentNavigator)
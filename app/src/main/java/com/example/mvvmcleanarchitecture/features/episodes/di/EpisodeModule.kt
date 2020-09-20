package com.example.mvvmcleanarchitecture.features.episodes.di

import com.example.mvvmcleanarchitecture.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.mvvmcleanarchitecture.features.episodes.domain.EpisodeRepository
import com.example.mvvmcleanarchitecture.features.episodes.domain.GetEpisodesUseCase
import com.example.mvvmcleanarchitecture.features.episodes.presentation.EpisodeAdapter
import com.example.mvvmcleanarchitecture.features.episodes.presentation.EpisodeFragment
import com.example.mvvmcleanarchitecture.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get(), get()) }
    factory { EpisodeFragment() }
    factory { EpisodeAdapter() }
}
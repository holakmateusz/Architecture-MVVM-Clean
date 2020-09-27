package com.example.mvvmcleanarchitecture.features.episodes.navigation

import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}
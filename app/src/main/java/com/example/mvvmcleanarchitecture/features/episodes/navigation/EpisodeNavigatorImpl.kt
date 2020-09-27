package com.example.mvvmcleanarchitecture.features.episodes.navigation

import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.mvvmcleanarchitecture.features.episodes.details.presentation.EpisodeDetailsFragment.Companion.EPISODE_DETAILS_KEY

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {
    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_episodes_screen_to_episode_detals_screen,
            EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}
package com.example.mvvmcleanarchitecture.features.episodes.all.presentation

import androidx.lifecycle.*
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.core.exception.ErrorMapper
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.mvvmcleanarchitecture.features.episodes.domain.GetEpisodesUseCase
import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode
import com.example.mvvmcleanarchitecture.features.episodes.navigation.EpisodeNavigator

class EpisodeViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase,
    private val episodeNavigator: EpisodeNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper),
    DefaultLifecycleObserver {

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>().also {
            getEpisodes(it)
        }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }

    private fun getEpisodes(episodesLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodesLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    internal fun onEpisodeClick(episode: EpisodeDisplayable) {
        episodeNavigator.openEpisodeDetailsScreen(episode)
    }
}
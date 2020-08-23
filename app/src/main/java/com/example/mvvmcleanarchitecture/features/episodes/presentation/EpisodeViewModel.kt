package com.example.mvvmcleanarchitecture.features.episodes.presentation

import androidx.lifecycle.*
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.features.episodes.domain.GetEpisodesUseCase
import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode
import com.example.mvvmcleanarchitecture.features.episodes.presentation.model.EpisodeDisplayable
import kotlinx.coroutines.Dispatchers

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : BaseViewModel(),
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
            scope = viewModelScope,
            executionDispatcher = Dispatchers.IO
        ) { result ->
            setIdleState()
            result.onSuccess { episodesLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}
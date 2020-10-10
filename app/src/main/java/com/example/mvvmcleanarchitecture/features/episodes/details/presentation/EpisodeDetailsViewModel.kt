package com.example.mvvmcleanarchitecture.features.episodes.details.presentation

import androidx.lifecycle.MutableLiveData
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeDetailsViewModel : BaseViewModel() {
    private val _episode: MutableLiveData<EpisodeDisplayable> by lazy {
        MutableLiveData<EpisodeDisplayable>()
    }
    val episode: MutableLiveData<EpisodeDisplayable> by lazy {
        _episode
    }

    internal fun setEpisode(episodeDisplayable: EpisodeDisplayable) {
        _episode.value = episodeDisplayable
    }
}
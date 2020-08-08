package com.example.mvvmcleanarchitecture.features.episodes.domain

import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}
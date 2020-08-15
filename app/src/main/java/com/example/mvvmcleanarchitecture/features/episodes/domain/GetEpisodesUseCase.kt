package com.example.mvvmcleanarchitecture.features.episodes.domain

import com.example.mvvmcleanarchitecture.core.base.UseCase
import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}
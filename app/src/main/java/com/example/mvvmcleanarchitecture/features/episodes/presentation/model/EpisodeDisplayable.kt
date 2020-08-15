package com.example.mvvmcleanarchitecture.features.episodes.presentation.model

import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode

data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val url: String
) {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        characters = episode.characters,
        url = episode.url,
        code = episode.code
    )
}
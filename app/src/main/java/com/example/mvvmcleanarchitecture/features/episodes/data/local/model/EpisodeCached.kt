package com.example.mvvmcleanarchitecture.features.episodes.data.local.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode

@Entity
data class EpisodeCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val url: String
) {
    constructor(episode: Episode) : this(
        episode.id,
        episode.name,
        episode.airDate,
        episode.characters,
        episode.code,
        episode.url
    )

    companion object

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        characters = characters,
        code = code,
        url = url
    )
}
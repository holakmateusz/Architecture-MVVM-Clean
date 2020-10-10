package com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model

import android.os.Parcelable
import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val url: String
) : Parcelable {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        characters = episode.characters,
        url = episode.url,
        code = episode.code
    )

    companion object
}
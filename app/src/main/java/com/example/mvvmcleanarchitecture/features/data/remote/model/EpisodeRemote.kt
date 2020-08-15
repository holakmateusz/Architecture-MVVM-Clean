package com.example.mvvmcleanarchitecture.features.data.remote.model

import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode
import com.google.gson.annotations.SerializedName

data class EpisodeRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("episode") val code: String,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        characters = characters,
        code = code,
        url = url
    )
}
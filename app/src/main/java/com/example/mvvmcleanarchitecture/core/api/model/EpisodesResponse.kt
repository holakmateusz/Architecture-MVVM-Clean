package com.example.mvvmcleanarchitecture.core.api.model

import com.google.gson.annotations.SerializedName

class EpisodesResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
) {
    companion object
}
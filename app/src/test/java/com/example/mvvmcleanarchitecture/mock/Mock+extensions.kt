package com.example.mvvmcleanarchitecture.mock

import com.example.mvvmcleanarchitecture.core.api.model.EpisodeRemote
import com.example.mvvmcleanarchitecture.core.api.model.EpisodesResponse
import com.example.mvvmcleanarchitecture.core.api.model.ResponseInfo
import com.example.mvvmcleanarchitecture.features.episodes.data.local.model.EpisodeCached
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 2,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url",
    created = "created"
)

fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url"
)



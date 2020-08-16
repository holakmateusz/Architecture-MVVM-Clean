package com.example.mvvmcleanarchitecture.mock

import com.example.mvvmcleanarchitecture.core.api.model.*
import com.example.mvvmcleanarchitecture.features.episodes.data.local.model.EpisodeCached
import com.example.mvvmcleanarchitecture.features.locations.data.local.model.LocationCached
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

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url"
)


@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    type = "type",
    dimension = "dimension",
    residents = emptyList(),
    url = "url",
    created = "created"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    type = "type",
    dimension = "dimension",
    residents = emptyList(),
    url = "url"
)
package com.example.mvvmcleanarchitecture.mock

import com.example.mvvmcleanarchitecture.core.api.model.*
import com.example.mvvmcleanarchitecture.features.characters.data.local.model.CharacterCached
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

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "name",
    url = "url"
)

@TestOnly
fun OriginRemote.Companion.mock() = OriginRemote(
    name = "name",
    url = "url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    episode = emptyList(),
    gender = "gender",
    image = "image",
    characterLocationRemote = CharacterLocationRemote.Companion.mock(),
    name = "name",
    originRemote = OriginRemote.Companion.mock(),
    species = "species",
    status = "status",
    type = "type",
    url = "url",
    created = "created"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    episode = emptyList(),
    gender = "gender",
    image = "image",
    name = "name",
    origin = OriginRemote.Companion.mock().toOrigin(),
    species = "species",
    characterLocation = CharacterLocationRemote.Companion.mock().toCharacterLocation(),
    status = "status",
    type = "type",
    url = "url"
)
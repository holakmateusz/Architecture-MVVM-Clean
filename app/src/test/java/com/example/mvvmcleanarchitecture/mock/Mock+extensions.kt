package com.example.mvvmcleanarchitecture.mock

import com.example.mvvmcleanarchitecture.core.api.model.*
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterLocationDisplayable
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.OriginDisplayable
import com.example.mvvmcleanarchitecture.features.characters.data.local.model.CharacterCached
import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character
import com.example.mvvmcleanarchitecture.features.characters.domain.model.CharacterLocation
import com.example.mvvmcleanarchitecture.features.characters.domain.model.Origin
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.mvvmcleanarchitecture.features.episodes.data.local.model.EpisodeCached
import com.example.mvvmcleanarchitecture.features.episodes.domain.model.Episode
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import com.example.mvvmcleanarchitecture.features.locations.data.local.model.LocationCached
import com.example.mvvmcleanarchitecture.features.locations.domain.model.Location
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

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "episode name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url"
)

@TestOnly
fun Origin.Companion.mock() = Origin(
    name = "name",
    url = "url"
)

@TestOnly
fun CharacterLocation.Companion.mock() = CharacterLocation(
    name = "name",
    url = "url"
)

@TestOnly
fun Character.Companion.mock() = Character(
    id = 1,
    episode = emptyList(),
    gender = "gender",
    image = "image",
    origin = Origin.mock(),
    name = "name",
    characterLocation = CharacterLocation.mock(),
    species = "species",
    status = "status",
    type = "type",
    url = "url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    id = 1,
    name = "location name",
    type = "type",
    dimension = "dimension",
    residents = emptyList(),
    url = "url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable(
    id = 1,
    name = "episode name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url"
)

@TestOnly
fun LocationDisplayable.Companion.mock() = LocationDisplayable(
    id = 1,
    name = "location name",
    type = "type",
    dimension = "dimension",
    residents = emptyList(),
    url = "url"
)

@TestOnly
fun OriginDisplayable.Companion.mock() = OriginDisplayable(
    name = "name",
    url = "url"
)

@TestOnly
fun CharacterLocationDisplayable.Companion.mock() = CharacterLocationDisplayable(
    name = "name",
    url = "url"
)

@TestOnly
fun CharacterDisplayable.Companion.mock() = CharacterDisplayable(
    id = 1,
    episode = emptyList(),
    gender = "gender",
    image = "image",
    origin = OriginDisplayable.mock(),
    name = "name",
    characterLocation = CharacterLocationDisplayable.mock(),
    species = "species",
    status = "status",
    type = "type",
    url = "url"
)
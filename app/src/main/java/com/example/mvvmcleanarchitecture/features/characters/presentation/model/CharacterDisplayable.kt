package com.example.mvvmcleanarchitecture.features.characters.presentation.model

import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character

data class CharacterDisplayable(
    val id: Int,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val name: String,
    val origin: OriginDisplayable,
    val species: String,
    val location: OriginDisplayable,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        id = character.id,
        created = character.created,
        episode = character.episode,
        gender = character.gender,
        image = character.image,
        name = character.name,
        origin = OriginDisplayable(character.origin),
        species = character.species,
        location = OriginDisplayable(character.origin),
        status = character.status,
        type = character.type,
        url = character.url
    )
}
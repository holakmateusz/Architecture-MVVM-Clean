package com.example.mvvmcleanarchitecture.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character
import com.example.mvvmcleanarchitecture.features.characters.domain.model.CharacterLocation
import com.example.mvvmcleanarchitecture.features.characters.domain.model.Origin

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val name: String,
    @Embedded(prefix = "Origin")
    val origin: Origin,
    val species: String,
    @Embedded(prefix = "CharacterLocation")
    val characterLocation: CharacterLocation,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        character.id,
        character.episode,
        character.gender,
        character.image,
        character.name,
        character.origin,
        character.species,
        character.characterLocation,
        character.status,
        character.type,
        character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        episode = episode,
        gender = gender,
        image = image,
        name = name,
        origin = origin,
        species = species,
        characterLocation = characterLocation,
        status = status,
        type = type,
        url = url
    )
}
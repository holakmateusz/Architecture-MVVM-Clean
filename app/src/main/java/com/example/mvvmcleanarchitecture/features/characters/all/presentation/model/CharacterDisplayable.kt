package com.example.mvvmcleanarchitecture.features.characters.all.presentation.model

import android.os.Parcelable
import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterDisplayable(
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val name: String,
    val origin: OriginDisplayable,
    val species: String,
    val characterLocation: CharacterLocationDisplayable,
    val status: String,
    val type: String,
    val url: String
) : Parcelable {
    constructor(character: Character) : this(
        id = character.id,
        episode = character.episode,
        gender = character.gender,
        image = character.image,
        name = character.name,
        origin = OriginDisplayable(character.origin),
        species = character.species,
        characterLocation = CharacterLocationDisplayable(character.characterLocation),
        status = character.status,
        type = character.type,
        url = character.url
    )

    companion object
}
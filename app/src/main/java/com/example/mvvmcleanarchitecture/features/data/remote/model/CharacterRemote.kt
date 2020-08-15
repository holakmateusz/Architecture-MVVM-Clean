package com.example.mvvmcleanarchitecture.features.data.remote.model

import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("image") val image: String,
    @SerializedName("location") val characterLocationRemote: CharacterLocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val originRemote: OriginRemote,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    fun toCharacter() = Character(
        id = id,
        created = created,
        episode = episode,
        gender = gender,
        image = image,
        characterLocation = characterLocationRemote.toCharacterLocation(),
        name = name,
        origin = originRemote.toOrigin(),
        species = species,
        status = status,
        type = type,
        url = url
    )
}
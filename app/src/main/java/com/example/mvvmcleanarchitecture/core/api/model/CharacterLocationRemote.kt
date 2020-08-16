package com.example.mvvmcleanarchitecture.core.api.model

import com.example.mvvmcleanarchitecture.features.characters.domain.model.CharacterLocation
import com.google.gson.annotations.SerializedName

class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}
package com.example.mvvmcleanarchitecture.features.characters.presentation.model

import com.example.mvvmcleanarchitecture.features.characters.domain.model.CharacterLocation

class CharacterLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )
}
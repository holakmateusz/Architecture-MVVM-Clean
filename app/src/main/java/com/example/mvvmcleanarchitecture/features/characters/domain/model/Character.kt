package com.example.mvvmcleanarchitecture.features.characters.domain.model

data class Character(
    val id: Int,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val name: String,
    val origin: Origin,
    val species: String,
    val characterLocation: CharacterLocation,
    val status: String,
    val type: String,
    val url: String
)
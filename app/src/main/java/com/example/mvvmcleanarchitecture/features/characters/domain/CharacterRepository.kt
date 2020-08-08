package com.example.mvvmcleanarchitecture.features.characters.domain

import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}
package com.example.mvvmcleanarchitecture.features.characters.domain

import com.example.mvvmcleanarchitecture.core.base.UseCase
import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}
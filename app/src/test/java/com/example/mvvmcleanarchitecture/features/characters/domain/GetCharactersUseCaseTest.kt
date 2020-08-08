package com.example.mvvmcleanarchitecture.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCharactersUseCaseTest {
    @Test
    fun `when use case is invoked then execute getCharacters method from repository`() {
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)
        useCase(
            params = Unit,
            scope = GlobalScope
        )
        coVerify {
            repository.getCharacters()
        }
    }
}
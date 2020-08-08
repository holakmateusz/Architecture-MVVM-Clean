package com.example.mvvmcleanarchitecture.features.episodes.domain

import com.example.mvvmcleanarchitecture.features.episodes.EpisodeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetEpisodesUseCaseTest {

    @Test
    fun `when use case is invoked then execute getEpisodes method from repository`() {
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)
        useCase(
            params = Unit,
            scope = GlobalScope
        )
        coVerify {
            repository.getEpisodes()
        }
    }
}
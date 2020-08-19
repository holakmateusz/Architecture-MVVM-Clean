package com.example.mvvmcleanarchitecture.features.episodes.data.repository

import com.example.mvvmcleanarchitecture.core.api.RickAndMortyApi
import com.example.mvvmcleanarchitecture.core.api.model.EpisodesResponse
import com.example.mvvmcleanarchitecture.core.network.NetworkStateProvider
import com.example.mvvmcleanarchitecture.features.episodes.data.local.EpisodeDao
import com.example.mvvmcleanarchitecture.features.episodes.data.local.model.EpisodeCached
import com.example.mvvmcleanarchitecture.features.episodes.domain.EpisodeRepository
import com.example.mvvmcleanarchitecture.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test


internal class EpisodeRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN episodes request THEN save episodes to local database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { episodeDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN episodes request THEN fetch episodes from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val episodeDao = mockk<EpisodeDao> {
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock(), EpisodeCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        //when
        runBlocking { repository.getEpisodes() }

        //then
        coVerify { episodeDao.getEpisodes() }
    }
}
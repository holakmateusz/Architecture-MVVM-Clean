package com.example.mvvmcleanarchitecture.features.characters.data.repository

import com.example.mvvmcleanarchitecture.core.api.RickAndMortyApi
import com.example.mvvmcleanarchitecture.core.network.NetworkStateProvider
import com.example.mvvmcleanarchitecture.features.characters.data.local.CharacterDao
import com.example.mvvmcleanarchitecture.features.characters.data.local.model.CharacterCached
import com.example.mvvmcleanarchitecture.features.characters.domain.CharacterRepository
import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote().also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters()
            .results.map { it.toCharacter() }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters().map { it.toCharacter() }
    }

    private suspend fun saveCharactersToLocal(episodes: List<Character>) {
        episodes.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }
}
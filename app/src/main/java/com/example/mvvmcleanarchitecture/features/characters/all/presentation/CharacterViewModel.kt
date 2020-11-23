package com.example.mvvmcleanarchitecture.features.characters.all.presentation

import androidx.lifecycle.*
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.core.exception.ErrorMapper
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import com.example.mvvmcleanarchitecture.features.characters.domain.GetCharactersUseCase
import com.example.mvvmcleanarchitecture.features.characters.domain.model.Character
import com.example.mvvmcleanarchitecture.features.characters.navigation.CharacterNavigator
import kotlinx.coroutines.flow.MutableStateFlow

class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val characterNavigator: CharacterNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper),
    DefaultLifecycleObserver {

    private val _characters by lazy {
        MutableStateFlow<List<Character>>(emptyList()).also {
            getCharacters(it)
        }
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.asLiveData().map { characters ->
            characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(charactersMutableStateFlow: MutableStateFlow<List<Character>>) {
        setPendingState()
        getCharactersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { charactersMutableStateFlow.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    internal fun onCharacterClick(character: CharacterDisplayable) {
        characterNavigator.openCharacterDetailsScreen(character)
    }
}
package com.example.mvvmcleanarchitecture.features.characters.details.presentation

import androidx.lifecycle.MutableLiveData
import com.example.mvvmcleanarchitecture.core.base.BaseViewModel
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable

class CharacterDetailsViewModel : BaseViewModel() {
    private val _character: MutableLiveData<CharacterDisplayable> by lazy {
        MutableLiveData<CharacterDisplayable>()
    }
    val character: MutableLiveData<CharacterDisplayable> by lazy {
        _character
    }

    internal fun setCharacter(characterDisplayable: CharacterDisplayable) {
        _character.value = characterDisplayable
    }
}
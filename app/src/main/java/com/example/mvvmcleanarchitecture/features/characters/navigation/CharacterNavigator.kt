package com.example.mvvmcleanarchitecture.features.characters.navigation

import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}
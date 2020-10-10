package com.example.mvvmcleanarchitecture.features.characters.navigation

import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import com.example.mvvmcleanarchitecture.features.characters.details.presentation.CharacterDetailsFragment

class CharacterNavigatorImpl(private val fragmentNavigator: FragmentNavigator) :
    CharacterNavigator {
    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_characters_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}
package com.example.mvvmcleanarchitecture.features.characters.navigation

import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import com.example.mvvmcleanarchitecture.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.Test

internal class CharacterNavigatorImplTest {
    @Test
    fun `When openCharacterDetailsScreen is called THEN invoke navigateTo method with appropriate action and character model as argument `() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        //when
        characterNavigator.openCharacterDetailsScreen(character)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_characters_screen_to_character_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe character
    }

    @Test
    fun `When goBack is called THEN invoke goBack method of FragmentNavigator `() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)

        //when
        characterNavigator.goBack()

        //then
        verify { fragmentNavigator.goBack() }
    }
}
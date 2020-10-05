package com.example.mvvmcleanarchitecture.features.characters.di

import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.CharacterAdapter
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.CharacterFragment
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.CharacterViewModel
import com.example.mvvmcleanarchitecture.features.characters.data.repository.CharacterRepositoryImpl
import com.example.mvvmcleanarchitecture.features.characters.details.presentation.CharacterDetailsFragment
import com.example.mvvmcleanarchitecture.features.characters.details.presentation.CharacterDetailsViewModel
import com.example.mvvmcleanarchitecture.features.characters.domain.CharacterRepository
import com.example.mvvmcleanarchitecture.features.characters.domain.GetCharactersUseCase
import com.example.mvvmcleanarchitecture.features.characters.navigation.CharacterNavigator
import com.example.mvvmcleanarchitecture.features.characters.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get(), get()) }
    viewModel { CharacterDetailsViewModel(get()) }
    factory { CharacterFragment() }
    factory { CharacterDetailsFragment() }
    factory { CharacterAdapter() }
    factory { provideCharacterNavigator(get()) }
}

fun provideCharacterNavigator(fragmentNavigator: FragmentNavigator): CharacterNavigator =
    CharacterNavigatorImpl(fragmentNavigator)
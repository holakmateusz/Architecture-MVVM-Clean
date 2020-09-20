package com.example.mvvmcleanarchitecture.features.characters.di

import com.example.mvvmcleanarchitecture.features.characters.data.repository.CharacterRepositoryImpl
import com.example.mvvmcleanarchitecture.features.characters.domain.CharacterRepository
import com.example.mvvmcleanarchitecture.features.characters.domain.GetCharactersUseCase
import com.example.mvvmcleanarchitecture.features.characters.presentation.CharacterAdapter
import com.example.mvvmcleanarchitecture.features.characters.presentation.CharacterFragment
import com.example.mvvmcleanarchitecture.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get()) }
    factory { CharacterFragment() }
    factory { CharacterAdapter() }
}
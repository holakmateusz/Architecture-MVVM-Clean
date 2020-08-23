package com.example.mvvmcleanarchitecture.core.di

import com.example.mvvmcleanarchitecture.features.characters.di.characterModule
import com.example.mvvmcleanarchitecture.features.episodes.di.episodeModule
import com.example.mvvmcleanarchitecture.features.locations.di.locationModule

val featuresModule = listOf(
    episodeModule,
    characterModule,
    locationModule
)
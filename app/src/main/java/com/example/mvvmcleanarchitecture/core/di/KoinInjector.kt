package com.example.mvvmcleanarchitecture.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
    appModule,
    networkModule,
    databaseModule
)
package com.example.mvvmcleanarchitecture.core.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmcleanarchitecture.core.database.AppDatabase
import com.example.mvvmcleanarchitecture.features.episodes.data.local.EpisodeDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { provideRoomDatabase(androidContext()) }
    single { provideEpisodeDao(get()) }
}

private fun provideRoomDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase").build()
}

private fun provideEpisodeDao(appDatabase: AppDatabase): EpisodeDao {
    return appDatabase.episodeDao()
}
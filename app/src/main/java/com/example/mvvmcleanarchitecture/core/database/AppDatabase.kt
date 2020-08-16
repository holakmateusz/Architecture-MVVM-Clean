package com.example.mvvmcleanarchitecture.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvmcleanarchitecture.features.episodes.data.local.EpisodeDao
import com.example.mvvmcleanarchitecture.features.episodes.data.local.model.EpisodeCached

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun episodeDao(): EpisodeDao
}
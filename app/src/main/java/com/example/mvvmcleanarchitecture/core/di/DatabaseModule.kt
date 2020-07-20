package com.example.mvvmcleanarchitecture.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmcleanarchitecture.features.data.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<RoomDatabase> { provideRoomDatabase(androidContext()) }
}

private fun provideRoomDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase").build()
}
package com.example.mvvmcleanarchitecture.core.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.features.characters.presentation.CharacterFragment
import com.example.mvvmcleanarchitecture.features.episodes.presentation.EpisodeFragment
import com.example.mvvmcleanarchitecture.features.locations.presentation.LocationFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val episodeFragment: EpisodeFragment by inject()
    private val characterFragment: CharacterFragment by inject()
    private val locationFragment: LocationFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            //TODO For testing app only, remove it after navigation added
            supportFragmentManager.beginTransaction().add(R.id.container, characterFragment)
                .commit()
        }
    }
}
package com.example.mvvmcleanarchitecture.features.characters.all.presentation.model

import android.os.Parcelable
import com.example.mvvmcleanarchitecture.features.characters.domain.model.CharacterLocation
import kotlinx.android.parcel.Parcelize

@Parcelize
class CharacterLocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )

    companion object
}
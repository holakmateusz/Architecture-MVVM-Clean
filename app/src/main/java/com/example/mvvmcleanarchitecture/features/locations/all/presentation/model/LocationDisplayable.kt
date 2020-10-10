package com.example.mvvmcleanarchitecture.features.locations.all.presentation.model

import android.os.Parcelable
import com.example.mvvmcleanarchitecture.features.locations.domain.model.Location
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationDisplayable(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
) : Parcelable {
    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        type = location.type,
        dimension = location.dimension,
        residents = location.residents,
        url = location.url
    )

    companion object
}
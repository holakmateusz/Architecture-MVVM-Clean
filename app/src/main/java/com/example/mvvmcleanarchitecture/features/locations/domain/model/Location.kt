package com.example.mvvmcleanarchitecture.features.locations.domain.model

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
)
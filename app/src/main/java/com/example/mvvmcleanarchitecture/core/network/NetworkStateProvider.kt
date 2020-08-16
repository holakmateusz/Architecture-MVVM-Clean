package com.example.mvvmcleanarchitecture.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}
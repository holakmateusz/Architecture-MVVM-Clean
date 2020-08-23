package com.example.mvvmcleanarchitecture.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}
package com.example.mvvmcleanarchitecture.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcleanarchitecture.core.exception.ErrorMapper
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel(private val errorMapper: ErrorMapper? = null) : ViewModel() {
    private val _message by lazy { LiveEvent<String>() }
    val message: LiveData<String> by lazy { _message }

    private val _uiState by lazy { MutableLiveData<UiState>(UiState.Idle) }
    val uiState: LiveData<UiState> by lazy { _uiState }

    private fun showMessage(message: String) {
        _message.value = message
    }

    protected fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    protected fun setPendingState() {
        _uiState.value = UiState.Pending
    }

    protected fun handleFailure(throwable: Throwable) {
        val errorMessage = errorMapper?.map(throwable)
        errorMessage ?: return
        showMessage(errorMessage)
    }
}
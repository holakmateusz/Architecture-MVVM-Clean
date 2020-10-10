package com.example.mvvmcleanarchitecture.core.bindings

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.example.mvvmcleanarchitecture.core.base.UiState

object BindingAdapters {

    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(progressBar: ProgressBar, uiState: UiState) {
        progressBar.visibility = if (uiState == UiState.Pending) View.VISIBLE else View.GONE
    }
}
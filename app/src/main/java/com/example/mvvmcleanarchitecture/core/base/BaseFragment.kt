package com.example.mvvmcleanarchitecture.core.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : BaseViewModel, K : ViewBinding>(@LayoutRes contentLayoutId: Int) :
    Fragment(contentLayoutId) {
    protected abstract val viewModel: T
    protected abstract var binding: K?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    open fun initViews() {

    }

    open fun initObservers() {
        observeUiState()
        observeMessage()
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

    private fun showToast(message: String?) {
        message ?: return
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun showToast(@StringRes messageResId: Int) {
        showToast(messageResId)
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                UiState.Idle -> {
                    onIdleState()
                }
                UiState.Pending -> {
                    onPendingState()
                }
            }
        }
    }

    open fun onIdleState() {

    }

    open fun onPendingState() {

    }
}
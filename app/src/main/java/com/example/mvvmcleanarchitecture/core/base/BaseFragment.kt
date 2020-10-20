package com.example.mvvmcleanarchitecture.core.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe

abstract class BaseFragment<T : BaseViewModel, K : ViewDataBinding>(
    private val viewModelId: Int,
    @LayoutRes contentLayoutId: Int
) :
    Fragment(contentLayoutId) {
    protected abstract val viewModel: T
    protected abstract var binding: K?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)
        binding?.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.setVariable(viewModelId, viewModel)
            initViews(it)
        }
        initObservers()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    open fun initViews(binding: K) {
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
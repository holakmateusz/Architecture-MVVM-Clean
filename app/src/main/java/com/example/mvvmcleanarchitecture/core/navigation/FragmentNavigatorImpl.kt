package com.example.mvvmcleanarchitecture.core.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.mvvmcleanarchitecture.core.provider.ActivityProvider

class FragmentNavigatorImpl(
    private val activityProvider: ActivityProvider,
    @IdRes private val navHostFragmentRes: Int,
    @IdRes private val homeDestinationRes: Int
) : FragmentNavigator {

    private fun getSupportFragmentManager() =
        (activityProvider.fragmentActivity as? FragmentActivity)?.supportFragmentManager

    private fun getNavController() =
        getSupportFragmentManager()?.findFragmentById(navHostFragmentRes)?.findNavController()

    override fun navigateTo(destinationId: Int) {
        getNavController()?.navigate(destinationId)
    }

    override fun goBack(destinationId: Int?, inclusive: Boolean) {
        if (destinationId == null) getNavController()?.popBackStack()
        else getNavController()?.popBackStack(destinationId, inclusive)
    }

    override fun clearHistory() {
        goBack(homeDestinationRes)
    }
}
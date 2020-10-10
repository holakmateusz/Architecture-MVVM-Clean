package com.example.mvvmcleanarchitecture.core.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.exception.ErrorMapper
import com.example.mvvmcleanarchitecture.core.exception.ErrorMapperImpl
import com.example.mvvmcleanarchitecture.core.exception.ErrorWrapper
import com.example.mvvmcleanarchitecture.core.exception.ErrorWrapperImpl
import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigator
import com.example.mvvmcleanarchitecture.core.navigation.FragmentNavigatorImpl
import com.example.mvvmcleanarchitecture.core.network.NetworkStateProvider
import com.example.mvvmcleanarchitecture.core.network.NetworkStateProviderImpl
import com.example.mvvmcleanarchitecture.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { provideLinearLayoutManager(androidContext()) }
    factory { provideGridLayoutManager(androidContext()) }
    factory { provideDividerItemDecoration(androidContext()) }
    factory { provideConnectivityManager(androidContext()) }
    factory { provideNetworkStateProvider(get()) }
    factory { provideErrorWrapper() }
    factory { provideErrorMapper(androidContext()) }
    single(createdAtStart = true) { provideActivityProvider(androidApplication()) }
    factory { provideDefaultNavOptions() }
    factory { provideFragmentNavigator(get(), get()) }
}

private fun provideLinearLayoutManager(androidContext: Context): LinearLayoutManager {
    return LinearLayoutManager(androidContext)
}

private fun provideGridLayoutManager(androidContext: Context): GridLayoutManager {
    return GridLayoutManager(androidContext, 2, GridLayoutManager.VERTICAL, false)
}

private fun provideDividerItemDecoration(androidContext: Context): DividerItemDecoration {
    return DividerItemDecoration(androidContext, LinearLayoutManager.VERTICAL)
}

private fun provideConnectivityManager(androidContext: Context): ConnectivityManager {
    return androidContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}

private fun provideNetworkStateProvider(connectivityManager: ConnectivityManager): NetworkStateProvider {
    return NetworkStateProviderImpl(connectivityManager)
}

private fun provideErrorWrapper(): ErrorWrapper {
    return ErrorWrapperImpl()
}

private fun provideErrorMapper(androidContext: Context): ErrorMapper {
    return ErrorMapperImpl(androidContext)
}

private fun provideActivityProvider(application: Application) = ActivityProvider(application)

private fun provideDefaultNavOptions(): NavOptions = navOptions {
    anim { enter = R.anim.fragment_fade_enter }
    anim { exit = R.anim.fragment_fade_exit }
    anim { popEnter = R.anim.fragment_close_enter }
    anim { popExit = R.anim.fragment_close_exit }
}

private fun provideFragmentNavigator(
    activityProvider: ActivityProvider,
    navOptions: NavOptions
): FragmentNavigator {
    return FragmentNavigatorImpl(
        activityProvider = activityProvider,
        navHostFragmentRes = R.id.nav_host_fragment,
        homeDestinationRes = R.id.characters_screen,
        defaultNavOptions = navOptions
    )
}
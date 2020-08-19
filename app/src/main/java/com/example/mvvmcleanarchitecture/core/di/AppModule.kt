package com.example.mvvmcleanarchitecture.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarchitecture.core.network.NetworkStateProvider
import com.example.mvvmcleanarchitecture.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { provideLinearLayoutManager(androidContext()) }

    factory { provideGridLayoutManager(androidContext()) }

    factory { provideDividerItemDecoration(androidContext()) }

    factory { provideConnectivityManager(androidContext()) }

    factory { provideNetworkStateProvider(get()) }
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
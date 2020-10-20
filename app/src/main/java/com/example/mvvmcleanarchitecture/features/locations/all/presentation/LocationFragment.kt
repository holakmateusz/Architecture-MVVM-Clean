package com.example.mvvmcleanarchitecture.features.locations.all.presentation

import com.example.mvvmcleanarchitecture.BR
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentLocationBinding
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment :
    BaseFragment<LocationViewModel, FragmentLocationBinding>(
        BR.viewModel,
        R.layout.fragment_location
    ),
    LocationAdapter.OnLocationListener {
    override val viewModel: LocationViewModel by viewModel()
    private val adapter: LocationAdapter by inject()
    override var binding: FragmentLocationBinding? = null

    override fun initViews(binding: FragmentLocationBinding) {
        initRecyclerView(binding)
    }

    private fun initRecyclerView(binding: FragmentLocationBinding) {
        adapter.onLocationListener = this@LocationFragment
        binding.locationContainer.adapter = adapter
    }

    override fun onClick(location: LocationDisplayable) {
        viewModel.onLocationClick(location)
    }
}
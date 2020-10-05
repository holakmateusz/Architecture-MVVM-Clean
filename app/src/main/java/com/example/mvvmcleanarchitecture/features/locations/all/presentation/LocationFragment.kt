package com.example.mvvmcleanarchitecture.features.locations.all.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentLocationBinding
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment :
    BaseFragment<LocationViewModel, FragmentLocationBinding>(R.layout.fragment_location),
    LocationAdapter.OnLocationListener {
    override val viewModel: LocationViewModel by viewModel()
    private val adapter: LocationAdapter by inject()
    override var binding: FragmentLocationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentLocationBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        initRecyclerView()
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        hideProgressBar()
    }

    override fun onPendingState() {
        showProgressBar()
    }

    private fun initRecyclerView() {
        adapter.onLocationListener = this@LocationFragment
        binding?.locationContainer?.adapter = adapter
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            showLocations(it)
        }
    }

    private fun hideProgressBar() {
        binding?.progressBarContainer?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBarContainer?.progressBar?.visibility = View.VISIBLE
    }

    private fun showLocations(locations: List<LocationDisplayable>) {
        adapter.setItems(locations)
    }

    override fun onClick(location: LocationDisplayable) {
        viewModel.onLocationClick(location)
    }
}
package com.example.mvvmcleanarchitecture.features.locations.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.example.mvvmcleanarchitecture.BR
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentLocationDetailsBinding
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel, FragmentLocationDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_location_details
    ) {
    override val viewModel: LocationDetailsViewModel by viewModel()
    override var binding: FragmentLocationDetailsBinding? = null

    companion object {
        internal const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { handleBundleData(it) }
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.location.observe(this) {
            showLocation(it)
        }
    }

    private fun handleBundleData(bundle: Bundle) {
        bundle.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let {
                viewModel.setLocation(it)
            }
    }

    private fun showLocation(location: LocationDisplayable) {
        binding?.apply {
            locationName.text = location.name
            locationType.text = location.type
        }
    }
}
package com.example.mvvmcleanarchitecture.features.episodes.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentEpisodeBinding
import com.example.mvvmcleanarchitecture.features.episodes.presentation.model.EpisodeDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment :
    BaseFragment<EpisodeViewModel, FragmentEpisodeBinding>(R.layout.fragment_episode) {
    override val viewModel: EpisodeViewModel by viewModel()
    private val layoutManager: LinearLayoutManager by inject()
    private val adapter: EpisodeAdapter by inject()
    override var binding: FragmentEpisodeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentEpisodeBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        initRecyclerView()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        hideProgressBar()
    }

    override fun onPendingState() {
        showProgressBar()
    }

    private fun initRecyclerView() {
        binding?.episodeContainer?.layoutManager = layoutManager
        binding?.episodeContainer?.adapter = adapter
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            showEpisodes(it)
        }
    }

    private fun hideProgressBar() {
        binding?.progressBarContainer?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBarContainer?.progressBar?.visibility = View.VISIBLE
    }

    private fun showEpisodes(episodes: List<EpisodeDisplayable>) {
        adapter.setItems(episodes)
    }
}
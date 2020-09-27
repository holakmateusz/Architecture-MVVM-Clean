package com.example.mvvmcleanarchitecture.features.episodes.details.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentEpisodeDetailsBinding
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel,
            FragmentEpisodeDetailsBinding>(R.layout.fragment_episode_details) {
    override val viewModel: EpisodeDetailsViewModel by viewModel()
    override var binding: FragmentEpisodeDetailsBinding? = null

    companion object {
        internal const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentEpisodeDetailsBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { handleBundleData(it) }
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.episode.observe(this) {
            showEpisode(it)
        }
    }

    private fun showEpisode(episode: EpisodeDisplayable) {
        binding?.firstEpisodeDetail?.episodeDetailsImage?.setImageResource(R.drawable.ic_episode)
        binding?.firstEpisodeDetail?.episodeDetailsDescription?.text = episode.name
        binding?.secondEpisodeDetail?.episodeDetailsImage?.setImageResource(R.drawable.ic_timeline)
        binding?.secondEpisodeDetail?.episodeDetailsDescription?.text = episode.airDate
        binding?.thirdEpisodeDetail?.episodeDetailsImage?.setImageResource(R.drawable.ic_numbered)
        binding?.thirdEpisodeDetail?.episodeDetailsDescription?.text = episode.code
    }

    private fun handleBundleData(bundle: Bundle) {
        bundle.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)?.let {
            viewModel.setEpisode(it)
        }
    }
}
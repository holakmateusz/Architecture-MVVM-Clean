package com.example.mvvmcleanarchitecture.features.episodes.all.presentation

import com.example.mvvmcleanarchitecture.BR
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentEpisodeBinding
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment :
    BaseFragment<EpisodeViewModel, FragmentEpisodeBinding>(
        BR.viewModel,
        R.layout.fragment_episode
    ),
    EpisodeAdapter.OnEpisodeListener {
    override val viewModel: EpisodeViewModel by viewModel()
    private val adapter: EpisodeAdapter by inject()
    override var binding: FragmentEpisodeBinding? = null

    override fun initViews(binding: FragmentEpisodeBinding) {
        initRecyclerView(binding)
    }

    private fun initRecyclerView(binding: FragmentEpisodeBinding) {
        adapter.onEpisodeListener = this@EpisodeFragment
        binding.episodeContainer.adapter = adapter
    }

    override fun onClick(episode: EpisodeDisplayable) {
        viewModel.onEpisodeClick(episode)
    }
}
package com.example.mvvmcleanarchitecture.features.episodes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcleanarchitecture.core.base.BaseAdapter
import com.example.mvvmcleanarchitecture.databinding.ItemEpisodeBinding
import com.example.mvvmcleanarchitecture.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeAdapter : BaseAdapter<EpisodeDisplayable>() {
    override val items: MutableList<EpisodeDisplayable> by lazy { mutableListOf<EpisodeDisplayable>() }
    private lateinit var binding: ItemEpisodeBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val episode = items[position]
        (holder as EpisodeViewHolder).bind(episode)
    }

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeDisplayable) {
            binding.run {
                episodeName.text = episode.name
                episodeAirDate.text = episode.airDate
                episodeCode.text = episode.code
            }
        }
    }
}
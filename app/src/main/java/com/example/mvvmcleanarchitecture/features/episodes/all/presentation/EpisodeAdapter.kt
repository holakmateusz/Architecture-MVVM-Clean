package com.example.mvvmcleanarchitecture.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcleanarchitecture.core.base.BaseAdapter
import com.example.mvvmcleanarchitecture.databinding.ItemEpisodeBinding
import com.example.mvvmcleanarchitecture.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter : BaseAdapter<EpisodeDisplayable>() {
    internal lateinit var onEpisodeListener: OnEpisodeListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding, onEpisodeListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val episode = items[position]
        (holder as EpisodeViewHolder).bind(episode)
    }

    class EpisodeViewHolder(
        private val binding: ItemEpisodeBinding,
        private val onEpisodeListener: OnEpisodeListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeDisplayable) {
            binding.run {
                item = episode
                root.setOnClickListener {
                    onEpisodeListener.onClick(episode)
                }
                executePendingBindings()
            }
        }
    }

    interface OnEpisodeListener {
        fun onClick(episode: EpisodeDisplayable)
    }
}
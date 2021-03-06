package com.example.mvvmcleanarchitecture.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcleanarchitecture.core.base.BaseAdapter
import com.example.mvvmcleanarchitecture.databinding.ItemCharacterBinding
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter : BaseAdapter<CharacterDisplayable>() {
    internal lateinit var onCharacterListener: OnCharacterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, onCharacterListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = items[position]
        (holder as CharacterViewHolder).bind(character)
    }

    class CharacterViewHolder(
        private val binding: ItemCharacterBinding,
        private val onCharacterListener: OnCharacterListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterDisplayable) {
            binding.run {
                item = character
                root.setOnClickListener {
                    onCharacterListener.onClick(character)
                }
                executePendingBindings()
            }
        }
    }

    interface OnCharacterListener {
        fun onClick(character: CharacterDisplayable)
    }
}
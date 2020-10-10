package com.example.mvvmcleanarchitecture.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmcleanarchitecture.core.base.BaseAdapter
import com.example.mvvmcleanarchitecture.databinding.ItemCharacterBinding
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter : BaseAdapter<CharacterDisplayable>() {
    override val items: MutableList<CharacterDisplayable> by lazy { mutableListOf<CharacterDisplayable>() }
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
                root.setOnClickListener {
                    onCharacterListener.onClick(character)
                }
                Glide.with(root).load(character.image).into(imageView)
                characterName.text = character.name
                val speciesWithStatusLabel = "${character.status} - ${character.species}"
                characterSpecies.text = speciesWithStatusLabel
                characterLocation.text = character.characterLocation.name
                characterOrigin.text = character.origin.name
            }
        }
    }

    interface OnCharacterListener {
        fun onClick(character: CharacterDisplayable)
    }
}
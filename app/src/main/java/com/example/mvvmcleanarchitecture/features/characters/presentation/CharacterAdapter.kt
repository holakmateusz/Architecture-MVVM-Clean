package com.example.mvvmcleanarchitecture.features.characters.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmcleanarchitecture.core.base.BaseAdapter
import com.example.mvvmcleanarchitecture.databinding.ItemCharacterBinding
import com.example.mvvmcleanarchitecture.features.characters.presentation.model.CharacterDisplayable

class CharacterAdapter : BaseAdapter<CharacterDisplayable>() {
    override val items: MutableList<CharacterDisplayable> by lazy { mutableListOf<CharacterDisplayable>() }
    private lateinit var binding: ItemCharacterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = items[position]
        (holder as CharacterViewHolder).bind(character)
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterDisplayable) {
            binding.run {
                Glide.with(root).load(character.image).into(imageView)
                characterName.text = character.name
                val speciesWithStatusLabel = "${character.status} - ${character.species}"
                characterSpecies.text = speciesWithStatusLabel
                characterLocation.text = character.characterLocation.name
                characterOrigin.text = character.origin.name
            }
        }
    }
}
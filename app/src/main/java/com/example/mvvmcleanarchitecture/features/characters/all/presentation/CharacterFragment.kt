package com.example.mvvmcleanarchitecture.features.characters.all.presentation

import androidx.lifecycle.observe
import com.example.mvvmcleanarchitecture.BR
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentCharacterBinding
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel, FragmentCharacterBinding>(
    BR.viewModel,
    R.layout.fragment_character
),
    CharacterAdapter.OnCharacterListener {
    override val viewModel: CharacterViewModel by viewModel()
    private val adapter: CharacterAdapter by inject()
    override var binding: FragmentCharacterBinding? = null

    override fun initViews(binding: FragmentCharacterBinding) {
        initRecyclerView(binding)
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    private fun initRecyclerView(binding: FragmentCharacterBinding) {
        adapter.onCharacterListener = this@CharacterFragment
        binding.characterContainer.adapter = adapter
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            showCharacters(it)
        }
    }

    private fun showCharacters(characters: List<CharacterDisplayable>) {
        adapter.setItems(characters)
    }

    override fun onClick(character: CharacterDisplayable) {
        viewModel.onCharacterClick(character)
    }
}
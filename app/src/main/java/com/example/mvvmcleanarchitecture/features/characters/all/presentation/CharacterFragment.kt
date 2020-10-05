package com.example.mvvmcleanarchitecture.features.characters.all.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentCharacterBinding
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment :
    BaseFragment<CharacterViewModel, FragmentCharacterBinding>(R.layout.fragment_character),
    CharacterAdapter.OnCharacterListener {
    override val viewModel: CharacterViewModel by viewModel()
    private val adapter: CharacterAdapter by inject()
    override var binding: FragmentCharacterBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCharacterBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        initRecyclerView()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        hideProgressBar()
    }

    override fun onPendingState() {
        showProgressBar()
    }

    private fun initRecyclerView() {
        adapter.onCharacterListener = this@CharacterFragment
        binding?.characterContainer?.adapter = adapter
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            showCharacters(it)
        }
    }

    private fun hideProgressBar() {
        binding?.progressBarContainer?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBarContainer?.progressBar?.visibility = View.VISIBLE
    }

    private fun showCharacters(characters: List<CharacterDisplayable>) {
        adapter.setItems(characters)
    }

    override fun onClick(character: CharacterDisplayable) {
        viewModel.onCharacterClick(character)
    }
}
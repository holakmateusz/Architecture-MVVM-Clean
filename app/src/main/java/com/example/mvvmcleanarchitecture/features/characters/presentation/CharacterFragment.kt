package com.example.mvvmcleanarchitecture.features.characters.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentCharacterBinding
import com.example.mvvmcleanarchitecture.features.characters.presentation.model.CharacterDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {
    override val viewModel: CharacterViewModel by viewModel()
    private val layoutManager: LinearLayoutManager by inject()
    private val adapter: CharacterAdapter by inject()
    private var binding: FragmentCharacterBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCharacterBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
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
        binding?.characterContainer?.layoutManager = layoutManager
        binding?.characterContainer?.adapter = adapter
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            showCharacters(it)
        }
    }

    private fun hideProgressBar() {
        binding?.progressBar?.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding?.progressBar?.visibility = View.VISIBLE
    }

    private fun showCharacters(characters: List<CharacterDisplayable>) {
        adapter.setItems(characters)
    }
}
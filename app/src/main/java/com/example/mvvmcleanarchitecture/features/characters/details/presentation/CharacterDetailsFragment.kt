package com.example.mvvmcleanarchitecture.features.characters.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.example.mvvmcleanarchitecture.BR
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.core.base.BaseFragment
import com.example.mvvmcleanarchitecture.databinding.FragmentCharacterDetailsBinding
import com.example.mvvmcleanarchitecture.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel, FragmentCharacterDetailsBinding>
        (
        BR.viewModel,
        R.layout.fragment_character_details
    ) {
    override val viewModel: CharacterDetailsViewModel by viewModel()
    override var binding: FragmentCharacterDetailsBinding? = null

    companion object {
        internal const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { handleBundleData(it) }
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.character.observe(this) {
            showCharacter(it)
        }
    }

    private fun handleBundleData(bundle: Bundle) {
        bundle.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let {
                viewModel.setCharacter(it)
            }
    }

    private fun showCharacter(character: CharacterDisplayable) {
        binding?.apply {
            with(characterDetailsContainer) {
                Glide.with(requireContext()).load(character.image)
                    .into(imageView)
                item = character
                executePendingBindings()
            }
        }
    }
}
package com.example.mvvmcleanarchitecture.features.locations.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcleanarchitecture.core.base.BaseAdapter
import com.example.mvvmcleanarchitecture.databinding.ItemLocationBinding
import com.example.mvvmcleanarchitecture.features.locations.presentation.model.LocationDisplayable

class LocationAdapter : BaseAdapter<LocationDisplayable>() {
    override val items: MutableList<LocationDisplayable> by lazy { mutableListOf<LocationDisplayable>() }
    private lateinit var binding: ItemLocationBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val location = items[position]
        (holder as LocationViewHolder).bind(location)
    }

    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: LocationDisplayable) {
            binding.run {
                locationName.text = location.name
                locationType.text = location.type
            }
        }
    }
}
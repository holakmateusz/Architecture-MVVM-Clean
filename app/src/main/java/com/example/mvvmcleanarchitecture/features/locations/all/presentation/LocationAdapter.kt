package com.example.mvvmcleanarchitecture.features.locations.all.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcleanarchitecture.core.base.BaseAdapter
import com.example.mvvmcleanarchitecture.databinding.ItemLocationBinding
import com.example.mvvmcleanarchitecture.features.locations.all.presentation.model.LocationDisplayable

class LocationAdapter : BaseAdapter<LocationDisplayable>() {
    internal lateinit var onLocationListener: OnLocationListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding, onLocationListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val location = items[position]
        (holder as LocationViewHolder).bind(location)
    }

    class LocationViewHolder(
        private val binding: ItemLocationBinding,
        private val onLocationListener: OnLocationListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: LocationDisplayable) {
            binding.run {
                item = location
                root.setOnClickListener {
                    onLocationListener.onClick(location)
                }
                executePendingBindings()
            }
        }
    }

    interface OnLocationListener {
        fun onClick(location: LocationDisplayable)
    }
}
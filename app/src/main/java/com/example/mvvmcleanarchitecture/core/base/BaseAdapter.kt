package com.example.mvvmcleanarchitecture.core.base

import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcleanarchitecture.core.adapter.BindableAdapter

abstract class BaseAdapter<T> :
    BindableAdapter<T>,
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val items by lazy { mutableListOf<T>() }

    override fun setItems(items: List<T>) {
        if (items.isEmpty()) {
            return
        }
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}
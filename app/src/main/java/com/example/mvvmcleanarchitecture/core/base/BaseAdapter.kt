package com.example.mvvmcleanarchitecture.core.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected abstract val items: MutableList<T>

    fun setItems(items: List<T>) {
        if (items.isEmpty()) {
            return
        }
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}
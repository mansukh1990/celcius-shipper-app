package com.example.mvvmroomdatabasedaggerhiltpractice.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class GenericRecyclerViewAdapter<T : Any, VDB : ViewDataBinding>(
    @LayoutRes val layoutId: Int,
    private val onBind: (VDB, T) -> Unit
) : RecyclerView.Adapter<GenericRecyclerViewAdapter<T, VDB>.GenericViewHolder>() {

    inner class GenericViewHolder(val binding: VDB) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: T) {
            onBind.invoke(binding, item)
        }
    }

    var listItems = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        return GenericViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutId, parent, false
            )
        )
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bindData(listItems[position])
    }

    fun addListItems(list: MutableList<T>) {
        listItems = list
        notifyDataSetChanged()
    }
}
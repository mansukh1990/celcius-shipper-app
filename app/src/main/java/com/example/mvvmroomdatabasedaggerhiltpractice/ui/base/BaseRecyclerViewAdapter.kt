package com.example.mvvmroomdatabasedaggerhiltpractice.ui.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : Any, VDB : ViewDataBinding> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder<VDB>>() {

    class BaseViewHolder<VDB : ViewDataBinding>(var binding: VDB) :
        RecyclerView.ViewHolder(binding.root) {
    }

    var listItems = mutableListOf<T>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(items: List<T>) {
        listItems = items as MutableList<T>
        notifyDataSetChanged()
    }

    val itemClickListener: ((view: View, item: T, position: Int) -> Unit)? = null

    abstract fun getLayout(): Int

    override fun getItemCount() = listItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder<VDB>(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), getLayout(), parent, false)
    )

}
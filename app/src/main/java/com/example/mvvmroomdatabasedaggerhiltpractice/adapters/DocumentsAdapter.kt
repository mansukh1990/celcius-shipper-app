package com.example.mvvmroomdatabasedaggerhiltpractice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ItemLayoutDocumentsBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.DocumentsModel

class DocumentsAdapter(private val documentImageList: List<DocumentsModel>) :
    RecyclerView.Adapter<DocumentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemLayoutDocumentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return documentImageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(documentImageList[position])
    }

    inner class ViewHolder(val binding: ItemLayoutDocumentsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(documentsModel: DocumentsModel) {
            binding.imdPod.setImageResource(documentsModel.image)
        }

    }
}
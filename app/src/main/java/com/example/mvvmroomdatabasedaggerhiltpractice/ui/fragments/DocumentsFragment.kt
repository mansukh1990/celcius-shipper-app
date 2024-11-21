package com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.adapters.DocumentsAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.FragmentDocumentsBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.DocumentsModel
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DocumentsFragment : BaseFragment<FragmentDocumentsBinding>(
    FragmentDocumentsBinding::inflate
) {

    override fun bindViewData() {
        setDocumentsRecyclerView()

    }

    private fun setDocumentsRecyclerView() {
        binding.rvDocuments.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = DocumentsAdapter(documentImageList())
        }
    }

    private fun documentImageList(): List<DocumentsModel> {
        return arrayListOf(
            DocumentsModel(R.drawable.ic_img_document_upload),
            DocumentsModel(R.drawable.ic_img_document_upload),
            DocumentsModel(R.drawable.ic_img_document_upload),
            DocumentsModel(R.drawable.ic_img_document_upload),
            DocumentsModel(R.drawable.ic_img_document_upload),
            DocumentsModel(R.drawable.ic_img_document_upload),
            DocumentsModel(R.drawable.ic_img_document_upload),
        )
    }

    override fun setOnClickListener() {
    }
}
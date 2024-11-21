package com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomdatabasedaggerhiltpractice.adapters.GRNDocumentsAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.FragmentGRNDocumentsBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.GRNDocumentsModel
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GRNDocumentsFragment : BaseFragment<FragmentGRNDocumentsBinding>(
    FragmentGRNDocumentsBinding::inflate
) {
    override fun bindViewData() {
        setGRNDocumentsRecyclerView()

    }

    private fun setGRNDocumentsRecyclerView() {
        binding.rvGRNDocuments.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = GRNDocumentsAdapter(addedProductsDetailsList())
        }
    }

    private fun addedProductsDetailsList(): List<GRNDocumentsModel> {
        return arrayListOf(
            GRNDocumentsModel(
                "IK3533",
                "KA063378",
                "Asha Transport",
                "18/07/2024",
                "6:13 PM",
                "Satish Pal",
                "2586634314"
            ),
            GRNDocumentsModel(
                "GJ3533",
                "GJ063378",
                "Delhivery Transport",
                "12/07/2024",
                "12:13 PM",
                "Hemali Patel",
                "98787879878977"
            )
        )
    }

    override fun setOnClickListener() {
    }
}
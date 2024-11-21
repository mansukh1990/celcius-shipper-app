package com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.FragmentQualityCheckBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.QualityCheckModel
import com.example.mvvmroomdatabasedaggerhiltpractice.models.UploadPod
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseFragment
import com.example.shipperinboundorder.adapter.QualityCheckAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QualityCheckFragment : BaseFragment<FragmentQualityCheckBinding>(
    FragmentQualityCheckBinding::inflate
) {

    override fun bindViewData() {
        setRecyclerViewQualityCheck()

    }

    private fun setRecyclerViewQualityCheck() {
        binding.rvQualityCheck.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = QualityCheckAdapter(addedProductsDetailsList())

        }
    }

    private fun addedProductsDetailsList(): List<QualityCheckModel> {

        val podList = listOf(
            UploadPod(android.R.drawable.ic_menu_upload),
            UploadPod(android.R.drawable.ic_menu_upload),
            UploadPod(android.R.drawable.ic_menu_upload),
            UploadPod(android.R.drawable.ic_menu_upload),
            UploadPod(android.R.drawable.ic_menu_upload),
            UploadPod(android.R.drawable.ic_menu_upload),
        )
        return arrayListOf(
            QualityCheckModel(
                "BAC01",
                "Almond 1 kg",
                "8564785646",
                "66657565",
                "2313231",
                "25°C to 7O°C",
                false,
                podList
            ),
            QualityCheckModel(
                "BAC01",
                "Almond 1 kg",
                "8564785646",
                "342",
                "2313231",
                "25°C to 7O°C",
                false,
                podList
            ),
            QualityCheckModel(
                "BAC01",
                "Almond 1 kg",
                "8564785646",
                "424",
                "2313231",
                "25°C to 7O°C",
                false,
                podList
            ),
            QualityCheckModel(
                "BAC01",
                "Almond 1 kg",
                "8564785646",
                "2424",
                "2313231",
                "25°C to 7O°C",
                false,
                podList
            ),
            QualityCheckModel(
                "BAC01",
                "Almond 1 kg",
                "8564785646",
                "4224",
                "2313231",
                "25°C to 7O°C",
                false,
                podList
            ),
            QualityCheckModel(
                "BAC01",
                "Almond 1 kg",
                "8564785646",
                "8898",
                "2313231",
                "25°C to 7O°C",
                false,
                podList
            ),
            QualityCheckModel(
                "BAC01",
                "Almond 1 kg",
                "8564785646",
                "887897",
                "2313231",
                "25°C to 7O°C",
                false,
                podList
            ),
            QualityCheckModel(
                "BAC01",
                "Almond 1 kg",
                "8564785646",
                "8787897",
                "2313231",
                "25°C to 7O°C",
                false,
                podList
            ),
        )
    }

    override fun setOnClickListener() {
    }

}
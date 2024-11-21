package com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.adapters.GrnAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.FragmentGRNBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.GrnModel
import com.example.mvvmroomdatabasedaggerhiltpractice.models.UploadPod
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GRNFragment : BaseFragment<FragmentGRNBinding>(
    FragmentGRNBinding::inflate
) {
    override fun bindViewData() {
        setGRNRecyclerView()

    }

    private fun setGRNRecyclerView() {
        binding.rvAddedProductsDetails.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = GrnAdapter(addedProductsDetailsList())

        }
    }

    private fun addedProductsDetailsList(): List<GrnModel> {

        val podList = listOf(
            UploadPod(android.R.drawable.ic_menu_camera),
            UploadPod(android.R.drawable.ic_menu_camera),
            UploadPod(android.R.drawable.ic_menu_camera),
            UploadPod(android.R.drawable.ic_menu_camera),
            UploadPod(android.R.drawable.ic_menu_camera),
            UploadPod(android.R.drawable.ic_menu_camera),
        )
        return arrayListOf(
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
            GrnModel(
                "ALMN180824",
                "Almond 1 kg",
                "8564785646",
                "129088989",
                "29/11/2024",
                "25°C to 7O°C",
                false,
                podList
            ),
        )


    }

    override fun setOnClickListener() {
    }

}
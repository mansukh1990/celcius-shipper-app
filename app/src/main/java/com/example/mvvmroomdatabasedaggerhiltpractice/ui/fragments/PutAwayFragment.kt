package com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomdatabasedaggerhiltpractice.adapters.PutawayAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.FragmentPutawayBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.PutawayModel
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PutAwayFragment : BaseFragment<FragmentPutawayBinding>(
    FragmentPutawayBinding::inflate
) {
    override fun bindViewData() {
        setRecyclerViewPutaway()
    }

    private fun setRecyclerViewPutaway() {
        binding.rvPutaway.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PutawayAdapter(putawayList())
        }
    }

    private fun putawayList(): List<PutawayModel> {
        return arrayListOf(
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
            PutawayModel(
                "BAC01",
                "Almond 1 kg",
                "BAC01",
                "2313231",
                "Chiller Chamber",
                "Chillrack",
                "Frozloc1",
                false
            ),
        )
    }

    override fun setOnClickListener() {
    }

}
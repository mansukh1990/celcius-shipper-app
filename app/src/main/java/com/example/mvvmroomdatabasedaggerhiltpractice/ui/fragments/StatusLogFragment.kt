package com.example.mvvmroomdatabasedaggerhiltpractice.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomdatabasedaggerhiltpractice.adapters.StatusLogAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.FragmentStatusLogBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.Status
import com.example.mvvmroomdatabasedaggerhiltpractice.models.StatusLogModel
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatusLogFragment : BaseFragment<FragmentStatusLogBinding>(
    FragmentStatusLogBinding::inflate
) {
    override fun bindViewData() {
        setRecyclerViewStatusLog()

    }

    private fun setRecyclerViewStatusLog() {
        binding.rvStatusLog.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = StatusLogAdapter(statusLogList())
        }
    }

    private fun statusLogList(): List<StatusLogModel> {
        return arrayListOf(
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.Placed,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.ARRIVED,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.GRNPENDING,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.GRNINPROCESS,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.GRNCOMPLETED,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.QCPENDING,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.QCINPROCESS,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.QCCOMPLETED,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.PUTAWAYPENDING,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.PUTAWAYINPROCESS,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.PUTAWAYCOMPLETED,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.DISPATCHCOMPLETED,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.RETURN,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.RETURNORDER,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.MANIFEST,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.DISPATCH,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.PICKING,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.PICKINGCOMPLETED,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
            StatusLogModel(
                "Punit Sonagra - Worker",
                Status.ReturnCompleted,
                "21/08/2024 16:13:43",
                "N/A",
                false
            ),
        )
    }

    override fun setOnClickListener() {
    }

}
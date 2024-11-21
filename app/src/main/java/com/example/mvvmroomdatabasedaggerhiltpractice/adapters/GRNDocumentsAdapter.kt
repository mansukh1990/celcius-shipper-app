package com.example.mvvmroomdatabasedaggerhiltpractice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ItemLayoutGrnDocumentsBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.GRNDocumentsModel

class GRNDocumentsAdapter(
    private val grnDocumentsList: List<GRNDocumentsModel>
) : RecyclerView.Adapter<GRNDocumentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutGrnDocumentsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return grnDocumentsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(grnDocumentsList[position])
    }
    inner class ViewHolder(private val binding: ItemLayoutGrnDocumentsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(grnDocuments: GRNDocumentsModel) {
            binding.txtLRNumberValue.text = grnDocuments.lrNumber
            binding.txtVehicleNumberValue.text = grnDocuments.vehicleNumber
            binding.txtTransporterValue.text = grnDocuments.transporter
            binding.txtCreatedDateValue.text = grnDocuments.createdDate
            binding.txtTimeLabel.text = grnDocuments.createdTime
            binding.txtDriverValue.text = grnDocuments.driverName
            binding.txtDriverMobileNumberValue.text = grnDocuments.driverMobileNumber

        }

    }

}
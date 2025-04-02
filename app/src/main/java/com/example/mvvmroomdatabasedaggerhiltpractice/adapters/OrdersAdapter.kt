package com.example.mvvmroomdatabasedaggerhiltpractice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ItemLayoutWarehouseOrdersBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.enums.StatusType
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.Order
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.OrderStatus

class OrdersAdapter(
    private var orders: ArrayList<Order>,
    private val onEditClick: (Order) -> Unit,
    private val onViewClick: (Order) -> Unit
) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemLayoutWarehouseOrdersBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return OrderViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    fun updateOrders(newOrders: ArrayList<Order>) {
        orders.addAll(newOrders)
        notifyDataSetChanged()
    }

    inner class OrderViewHolder(private val binding: ItemLayoutWarehouseOrdersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            binding.txtIdCustValue.text = order.order_no
            binding.txtCustomerStatus.text = order.order_type
            binding.txtExpectedDateValue.text = order.expected_delivery_date
            binding.imgEdit.setOnClickListener {
                onEditClick(order)
            }
            binding.imgView.setOnClickListener {
                onViewClick(order)
            }

            when (order.order_type) {
                "inbound" -> {
                    binding.imgInbound.visibility = ViewGroup.VISIBLE
                    binding.imgOutbound.visibility = ViewGroup.GONE
                    binding.txtCustomerStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_inbound)
                }

                "outbound" -> {
                    binding.imgInbound.visibility = ViewGroup.GONE
                    binding.imgOutbound.visibility = ViewGroup.VISIBLE
                    binding.txtCustomerStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_outbound)

                }

            }

            when (order.order_status) {
                OrderStatus(StatusType.Placed.id, StatusType.Placed.type) -> {
                    binding.btnStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_order_placed)
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.clr_text_order_placed
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_check,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_order_placed
                    )
                    binding.txtCreatedByValue.text = order.created_by_type
                }

                OrderStatus(StatusType.Arrived.id, StatusType.Arrived.type) -> {
                    binding.btnStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_arrived)
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.clr_text_order_arrived
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_check,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_arrived
                    )
                    binding.txtCreatedByValue.text = order.created_by_type

                }

//                OrderStatus(StatusType.GRNPENDING.id, StatusType.GRNPENDING.type) -> {
//                    binding.btnStatus.text =
//                        ContextCompat.getString(binding.root.context, R.string.str_grn_pending)
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.white
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_grn_pending,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_grn_pending
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//
//                }

//                Status.GRNINPROCESS.toString() -> {
//                    binding.btnStatus.text =
//                        ContextCompat.getString(binding.root.context, R.string.str_grn_in_process)
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.clr_text_grn_in_process
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_grn_in_process,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_grn_in_process
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//
//                }

//                Status.GRNCOMPLETED.toString() -> {
//                    binding.btnStatus.text =
//                        ContextCompat.getString(binding.root.context, R.string.str_grn_completed)
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.white
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_check_white,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_grn_completed
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//
//                }

//                Status.QCPENDING.toString() -> {
//                    binding.btnStatus.text =
//                        ContextCompat.getString(binding.root.context, R.string.str_qc_pending)
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.white
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_grn_pending,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_qc_pending
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//
//                }

//                Status.QCINPROCESS.toString() -> {
//                    binding.btnStatus.text =
//                        ContextCompat.getString(binding.root.context, R.string.str_qc_in_process)
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.clr_text_qc_in_process
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_process,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_qc_process
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//
//                }

                OrderStatus(StatusType.QC_Completed.id, StatusType.QC_Completed.type) -> {
                    binding.btnStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_qc_completed)
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.white
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_check_white,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_qc_completed
                    )
                    binding.txtCreatedByValue.text = order.created_by_type
                }

//                Status.PUTAWAYPENDING.toString() -> {
//                    binding.btnStatus.text =
//                        ContextCompat.getString(binding.root.context, R.string.str_putaway_pending)
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.white
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_grn_pending,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_qc_pending
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//                }

//                Status.PUTAWAYINPROCESS.toString() -> {
//                    binding.btnStatus.text = ContextCompat.getString(
//                        binding.root.context,
//                        R.string.str_putaway_in_process
//                    )
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.clr_text_qc_in_process
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_process,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_puyayay_in_process
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//                }

                OrderStatus(
                    StatusType.Put_Away_Completed.id,
                    StatusType.Put_Away_Completed.type
                ) -> {
                    binding.btnStatus.text = ContextCompat.getString(
                        binding.root.context,
                        R.string.str_putaway_completed
                    )
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.white
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_check_white,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_qc_completed
                    )
                    binding.txtCreatedByValue.text = order.created_by_type
                }

//                Status.DISPATCHCOMPLETED.toString() -> {
//                    binding.btnStatus.text = ContextCompat.getString(
//                        binding.root.context,
//                        R.string.str_dispatch_completed
//                    )
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.white
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_check_white,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_qc_completed
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//                }

//                Status.RETURN.toString() -> {
//                    binding.btnStatus.text =
//                        ContextCompat.getString(binding.root.context, R.string.str_return)
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.clr_text_return
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_return,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_return
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//                }

                OrderStatus(StatusType.RETURNORDER.id, StatusType.RETURNORDER.type) -> {
                    binding.btnStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_return_order)
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.clr_text_return
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_return,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_return
                    )
                    binding.txtCreatedByValue.text = order.created_by_type
                }

                OrderStatus(StatusType.MANIFEST.id, StatusType.MANIFEST.type) -> {
                    binding.btnStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_manifest)
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.clr_text_manifest
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_process,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_manifest
                    )
                    binding.txtCreatedByValue.text = order.created_by_type
                }

//                Status.DISPATCH.toString() -> {
//                    binding.btnStatus.text =
//                        ContextCompat.getString(binding.root.context, R.string.str_dispatch)
//                    binding.btnStatus.setTextColor(
//                        ContextCompat.getColor(
//                            binding.root.context,
//                            R.color.clr_text_manifest
//                        )
//                    )
//                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
//                        R.drawable.ic_process,
//                        0,
//                        0,
//                        0
//                    )
//                    binding.btnStatus.background = ContextCompat.getDrawable(
//                        binding.root.context,
//                        R.drawable.bg_manifest
//                    )
//                    binding.txtCreatedByValue.text = order.created_by_type
//                }

                OrderStatus(StatusType.PICKING.id, StatusType.PICKING.type) -> {
                    binding.btnStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_picking)
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.clr_text_manifest
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_process,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_manifest
                    )
                    binding.txtCreatedByValue.text = order.created_by_type
                }

                OrderStatus(StatusType.PICKINGCOMPLETED.id, StatusType.PICKINGCOMPLETED.type) -> {
                    binding.btnStatus.text = ContextCompat.getString(
                        binding.root.context,
                        R.string.str_picking_completed
                    )
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.white
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_check_white,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_qc_completed
                    )
                    binding.txtCreatedByValue.text = order.created_by_type
                }

                OrderStatus(StatusType.RETURNCOMPLETED.id, StatusType.RETURNCOMPLETED.type) -> {
                    binding.btnStatus.text =
                        ContextCompat.getString(binding.root.context, R.string.str_return_completed)
                    binding.btnStatus.setTextColor(
                        ContextCompat.getColor(
                            binding.root.context,
                            R.color.clr_text_return
                        )
                    )
                    binding.btnStatus.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.ic_return,
                        0,
                        0,
                        0
                    )
                    binding.btnStatus.background = ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.bg_return
                    )
                    binding.txtCreatedByValue.text = order.created_by_type

                }
            }
        }

    }
}
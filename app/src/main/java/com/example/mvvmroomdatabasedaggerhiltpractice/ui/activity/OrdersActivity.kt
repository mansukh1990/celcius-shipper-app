package com.example.mvvmroomdatabasedaggerhiltpractice.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.adapters.OrdersAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ActivityOrdersBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.requests.OrderRequest
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.Order
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.Resource
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseActivity
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.EndlessRecyclerViewScrollListener
import com.example.mvvmroomdatabasedaggerhiltpractice.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersActivity : BaseActivity<ActivityOrdersBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: OrdersAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var scrollListener: EndlessRecyclerViewScrollListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar(getString(R.string.str_orders))

        binding.swOrder.setOnRefreshListener {
            binding.swOrder.isRefreshing = false
        }

        layoutManager = LinearLayoutManager(this)
        setupRecyclerViewOrders()

        viewModel.orders.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    if (viewModel.isFirstPage) {
                        showProgressDialog()
                    }

                }

                is Resource.Success -> {
                    dismissProgressDialog()
                    adapter.updateOrders(it.data!!.data)

                }

                is Resource.Failure -> {
                    dismissProgressDialog()
                    it.message.toString()

                }
            }

        }

    }

    override fun inflateBinding() = ActivityOrdersBinding.inflate(layoutInflater)

    override fun bindViewData() {
    }

    private fun setupRecyclerViewOrders() {
        binding.rcOrders.setHasFixedSize(true)
        binding.rcOrders.layoutManager = LinearLayoutManager(this)
        adapter = OrdersAdapter(orders = arrayListOf(), onEditClick = {
            openEditOrderActivity(order = it)
        }, onViewClick = {
            openViewOrderActivity(order = it)
        })
        binding.rcOrders.adapter = adapter
    }

    private fun openViewOrderActivity(order: Order) {
        val intent = Intent(this, ViewInboundOrdersActivity::class.java)
        intent.putExtra("order_id", order.encrypted_id)
        startActivity(intent)
    }

    private fun openEditOrderActivity(order: Order) {
        val intent = Intent(this, CreateInboundOrderActivity::class.java)
        intent.putExtra("order_id", order.encrypted_id)
        startActivity(intent)
    }

    override fun setOnclickListeners() {
        binding.btnInbound.setOnClickListener {
            startActivity(Intent(this, CreateInboundOrderActivity::class.java))
            finish()
        }

    }

    override fun observeData() {
        viewModel.fetchOrders(
            orderRequest = OrderRequest("450", "", "", "", "", "", "1")
        )

    }

}
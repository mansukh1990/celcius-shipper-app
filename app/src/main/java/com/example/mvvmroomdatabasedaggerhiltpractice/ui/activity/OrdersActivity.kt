package com.example.mvvmroomdatabasedaggerhiltpractice.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.adapters.OrdersAdapter
import com.example.mvvmroomdatabasedaggerhiltpractice.databinding.ActivityOrdersBinding
import com.example.mvvmroomdatabasedaggerhiltpractice.models.requests.OrderRequest
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.CustomerDetails
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.Order
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.OrderStatus
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.Resource
import com.example.mvvmroomdatabasedaggerhiltpractice.ui.base.BaseActivity
import com.example.mvvmroomdatabasedaggerhiltpractice.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersActivity : BaseActivity<ActivityOrdersBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: OrdersAdapter
    private var currentPage = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setToolbar(getString(R.string.str_orders))
      //  setupRecyclerViewOrders()
    //    observeData()


    }

    override fun inflateBinding() = ActivityOrdersBinding.inflate(layoutInflater)

    override fun bindViewData() {
        setupRecyclerViewOrders()
    }

    private fun setupRecyclerViewOrders() {
        adapter = OrdersAdapter(orders = mutableListOf(), onEditClick = {
            openEditOrderActivity(order = it)
        }, onViewClick = {
            openViewOrderActivity(order = it)
        })
        binding.rcOrders.layoutManager = LinearLayoutManager(this)
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
        viewModel.orders.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    showProgressDialog()
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
        viewModel.fetchOrders(
            orderRequest = OrderRequest("450", "", "", "", "", "", "1")
        )


    }

    private fun addData(): MutableList<Order> {
        return arrayListOf(
            Order(
                "dfsfsf",
                customer_details = CustomerDetails("dasdad", "dad", 7997),
                432432,
                "sfsfdsf",
                "ffsdf",
                "dsdad",
                42342,
                12 / 12 / 24,
                "sdad",
                order_status = OrderStatus(4242, "mqdh"),
                "dsad",
                "dddas",
                2,
                "sSSA",
                "SAs"
            ), Order(
                "dfsfsf",
                customer_details = CustomerDetails("dasdad", "dad", 7997),
                432432,
                "sfsfdsf",
                "ffsdf",
                "dsdad",
                42342,
                12 / 12 / 24,
                "sdad",
                order_status = OrderStatus(4242, "mqdh"),
                "dsad",
                "dddas",
                2,
                "sSSA",
                "SAs"
            ), Order(
                "dfsfsf",
                customer_details = CustomerDetails("dasdad", "dad", 7997),
                432432,
                "sfsfdsf",
                "ffsdf",
                "dsdad",
                42342,
                12 / 12 / 24,
                "sdad",
                order_status = OrderStatus(4242, "mqdh"),
                "dsad",
                "dddas",
                2,
                "sSSA",
                "SAs"
            ),
            Order(
                "dfsfsf",
                customer_details = CustomerDetails("dasdad", "dad", 7997),
                432432,
                "sfsfdsf",
                "ffsdf",
                "dsdad",
                42342,
                12 / 12 / 24,
                "sdad",
                order_status = OrderStatus(4242, "mqdh"),
                "dsad",
                "dddas",
                2,
                "sSSA",
                "SAs"
            ),
            Order(
                "dfsfsf",
                customer_details = CustomerDetails("dasdad", "dad", 7997),
                432432,
                "sfsfdsf",
                "ffsdf",
                "dsdad",
                42342,
                12 / 12 / 24,
                "sdad",
                order_status = OrderStatus(4242, "mqdh"),
                "dsad",
                "dddas",
                2,
                "sSSA",
                "SAs"
            ),
            Order(
                "dfsfsf",
                customer_details = CustomerDetails("dasdad", "dad", 7997),
                432432,
                "sfsfdsf",
                "ffsdf",
                "dsdad",
                42342,
                12 / 12 / 24,
                "sdad",
                order_status = OrderStatus(4242, "mqdh"),
                "dsad",
                "dddas",
                2,
                "sSSA",
                "SAs"
            )
        )
    }
}
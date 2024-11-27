package com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse

data class Order(
    val created_by_type: String,
    val customer_details: CustomerDetails,
    val customer_id: String,
    val encrypted_id: String,
    val expected_delivery_date: String,
    val external_order_no: String,
    val id: String,
    val is_sto_order: String,
    val order_no: String,
    val order_status: OrderStatus,
    val order_type: String,
    val return_order_date: String,
    val status: String,
    val status_name: String,
    val sto_order_no: String
)
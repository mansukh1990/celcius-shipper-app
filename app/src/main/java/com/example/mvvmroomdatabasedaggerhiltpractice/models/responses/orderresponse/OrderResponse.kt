package com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse

data class OrderResponse(
    val `data`: List<Order>,
    val paginate: Paginate,
    val response: String,
    val responseCode: Int,
    val status: String
)
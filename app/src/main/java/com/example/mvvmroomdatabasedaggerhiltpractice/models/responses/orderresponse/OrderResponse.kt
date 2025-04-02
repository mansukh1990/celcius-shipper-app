package com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse

data class OrderResponse(
    var data: ArrayList<Order>,
    val paginate: Paginate,
    val response: String,
    val responseCode: String,
    val status: String
)
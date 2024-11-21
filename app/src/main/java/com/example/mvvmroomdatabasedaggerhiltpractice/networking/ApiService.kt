package com.example.mvvmroomdatabasedaggerhiltpractice.networking

import com.example.mvvmroomdatabasedaggerhiltpractice.models.requests.LoginRequest
import com.example.mvvmroomdatabasedaggerhiltpractice.models.requests.OrderRequest
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.LoginResponse
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.OrderResponse
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.ApiConstants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(ApiConstants.LOGIN)
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST(ApiConstants.ORDER_LIST)
    suspend fun getOrders(
        @Body orderRequest: OrderRequest
    ): Response<OrderResponse>
}
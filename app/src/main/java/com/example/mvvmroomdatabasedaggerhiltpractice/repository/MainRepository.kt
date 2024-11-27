package com.example.mvvmroomdatabasedaggerhiltpractice.repository

import com.example.mvvmroomdatabasedaggerhiltpractice.models.requests.LoginRequest
import com.example.mvvmroomdatabasedaggerhiltpractice.models.requests.OrderRequest
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.LoginResponse
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.OrderResponse
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.ApiService
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.GenericApiResponse
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.Resource
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.SharedPrefManager
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val sharedPrefManager: SharedPrefManager
) : GenericApiResponse() {

    suspend fun loginUser(
        email: String,
        password: String,
        appVersion: String
    ): Resource<LoginResponse> {
        return safeApiCall {
            apiService.loginUser(LoginRequest(email, password, appVersion))
        }
    }

    fun isLoggedIn(): Boolean = sharedPrefManager.isLoggedIn()


    suspend fun getOrders(orderRequest: OrderRequest): Resource<OrderResponse> {
        return safeApiCall { apiService.getOrders(orderRequest = orderRequest) }

    }

}


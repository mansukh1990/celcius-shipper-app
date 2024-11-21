package com.example.mvvmroomdatabasedaggerhiltpractice.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmroomdatabasedaggerhiltpractice.models.requests.LoginRequest
import com.example.mvvmroomdatabasedaggerhiltpractice.models.requests.OrderRequest
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.LoginResponse
import com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse.OrderResponse
import com.example.mvvmroomdatabasedaggerhiltpractice.networking.Resource
import com.example.mvvmroomdatabasedaggerhiltpractice.repository.MainRepository
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.SharedPrefManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val sharedPrefManager: SharedPrefManager
) : ViewModel() {

    private val _loginResponse = MutableLiveData<Resource<LoginResponse>>()
    val loginResponse: LiveData<Resource<LoginResponse>> get() = _loginResponse

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _loginResponse.value = Resource.Loading()

            val result = repository.loginUser(LoginRequest(email, password, "37"))
            if (result is Resource.Success) {
                sharedPrefManager.saveToken(result.data!!.data!!.token!!)
                Log.e("token", result.data.data!!.token!!)
                sharedPrefManager.getToken()?.let { Log.e("token", it) }
            }
            _loginResponse.value = result
            _loginResponse.value = Resource.Failure(result.message.toString())
        }
    }

    fun isLoggedIn(): Boolean = repository.isLoggedIn()

    private val _orders = MutableLiveData<Resource<OrderResponse>>()
    val orders: LiveData<Resource<OrderResponse>> get() = _orders

    fun fetchOrders(
        orderRequest: OrderRequest
    ) {
        viewModelScope.launch {
            _orders.value = Resource.Loading()

            val token = sharedPrefManager.getToken()
            Log.e("ordertoken", "fetchOrders: ${token.toString()}")
            val response = repository.getOrders(orderRequest = orderRequest)
            _orders.value = Resource.Success(response.data!!)
            _orders.value = Resource.Failure(response.message.toString())

        }
    }

}
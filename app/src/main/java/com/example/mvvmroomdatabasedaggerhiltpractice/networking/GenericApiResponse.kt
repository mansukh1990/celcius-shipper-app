package com.example.mvvmroomdatabasedaggerhiltpractice.networking

import retrofit2.Response

abstract class GenericApiResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()
                body?.let {
                    return Resource.Success(body)
                }
            }
            return Resource.Failure(response.message())

        } catch (e: Exception) {
            return Resource.Failure(e.message!!)

        }
    }
}
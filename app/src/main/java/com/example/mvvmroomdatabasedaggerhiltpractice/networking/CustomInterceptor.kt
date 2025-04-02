package com.example.mvvmroomdatabasedaggerhiltpractice.networking

import android.app.Application
import com.example.mvvmroomdatabasedaggerhiltpractice.R
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.SharedPrefManager
import com.example.mvvmroomdatabasedaggerhiltpractice.utils.Util
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException
import javax.inject.Inject

class CustomInterceptor @Inject constructor(private val application: Application) : Interceptor {

    private lateinit var response: Response

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    override fun intercept(chain: Interceptor.Chain): Response {
        sharedPrefManager = SharedPrefManager(context = application)
        if (!Util.isNetworkConnected(application)) {
            throw IOException(application.getString(R.string.no_internet_connection))
        }
        val request = chain.request().newBuilder()

        val token = sharedPrefManager.getToken()
        request.addHeader("Authorization", "Bearer $token")
        request.addHeader("Accept", "application/json")

        try {
            response = chain.proceed(request.build())

        } catch (e: Exception) {
            throw IOException(e.message)
        }
        return response
    }
}
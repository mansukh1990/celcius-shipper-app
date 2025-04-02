package com.example.mvvmroomdatabasedaggerhiltpractice.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefManager @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("CelciusLogistics", Context.MODE_PRIVATE)

    companion object {
        const val TOKEN = "token"
    }

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN, token).apply()
    }

    fun isLoggedIn(): Boolean {
        return getToken() != null
    }

    fun getToken(): String? {
        return sharedPreferences.getString(TOKEN, null)
    }

    fun clearToken() {
        sharedPreferences.edit().remove(TOKEN).apply()
    }
}
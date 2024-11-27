package com.example.mvvmroomdatabasedaggerhiltpractice.utils

object Logger {

    val TAG = "Celcius Log---"

    private var isDebugMode = false

    fun enableDebugMode(debug: Boolean) {
        isDebugMode = debug
    }

    fun d(message: String) {
        if (isDebugMode) {
            android.util.Log.d(TAG, message)
        }
    }

    fun e(message: String) {
        if (isDebugMode) {
            android.util.Log.e(TAG, message)
        }
    }


}
package com.example.mvvmroomdatabasedaggerhiltpractice.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog

object Util {

    fun emptyString(): String {
        return ""
    }

    fun Context.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    fun showDialog(
        context: Context,
        type: Int,
        title: String,
        content: String,
        confirmText: String,
        cancelText: String,
        onConfirm: (() -> Unit)? = null,
        onCancel: (() -> Unit)? = null
    ) {
        val sweetAlertDialog = SweetAlertDialog(context, type)
        sweetAlertDialog
            .setTitleText(title)
            .setContentText(content)
            .setConfirmText(confirmText)
            .setCancelText(cancelText)
            .setConfirmClickListener { dialog ->
                dialog.dismissWithAnimation()
                onConfirm?.invoke()
            }
            .setCancelClickListener { dialog ->
                dialog.dismissWithAnimation()
                onCancel?.invoke()
            }
        sweetAlertDialog.setCanceledOnTouchOutside(true)
        sweetAlertDialog.setCancelable(true)

        sweetAlertDialog.show()
    }


    fun isNetworkConnected(application: Application): Boolean {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var result = false
        connectivityManager.let {
            it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            }
        }
        return result
    }
}
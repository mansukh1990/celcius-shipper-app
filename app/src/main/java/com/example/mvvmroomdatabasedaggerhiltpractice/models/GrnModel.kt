package com.example.mvvmroomdatabasedaggerhiltpractice.models


data class GrnModel (
    val batchCode: String,
    val skuName: String,
    val barcode: String,
    val quantity: String,
    val expiryDate: String,
    val temp: String,
    var expand: Boolean = false,
    val uploadPodList : List<UploadPod>
)
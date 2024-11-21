package com.example.mvvmroomdatabasedaggerhiltpractice.models

data class QualityCheckModel(
    val batchCode: String,
    val skuName: String,
    val barcode: String,
    val quantity: String,
    val damagedQty: String,
    val temp: String,
    var expand: Boolean = false,
    var uploadPodList: List<UploadPod>
)

data class UploadPod(
    val image: Int
)

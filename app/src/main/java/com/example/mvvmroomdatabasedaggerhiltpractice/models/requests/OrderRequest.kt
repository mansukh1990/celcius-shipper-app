package com.example.mvvmroomdatabasedaggerhiltpractice.models.requests

data class OrderRequest(
	val customer_id: String,
	val order_type: String,
	val search: String,
	val sort_key: String,
	val sort_order: String,
	val status: String,
	val warehouse: String
)


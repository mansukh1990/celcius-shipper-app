package com.example.mvvmroomdatabasedaggerhiltpractice.models.responses.orderresponse

data class Paginate(
    val current_page: String,
    val first_page_url: String,
    val last_page: String,
    val last_page_url: String,
    val next_page_url: String,
    val per_page: String,
    val prev_page_url: String,
    val total: String
)
package com.example.mvvmroomdatabasedaggerhiltpractice.models.requests

data class LoginRequest(
    val email: String,
    val password: String,
    val app_version: String
)
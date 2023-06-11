package com.example.adiva.db

data class user(
    val request_id: String,
    val request_time: String,
    val response_time: String,
    val result: Result,
    val status: String,
    val summary: String
)
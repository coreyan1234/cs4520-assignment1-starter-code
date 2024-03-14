package com.cs4520.assignment1.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val baseUrl = "https://kgtttq6tg9.execute-api.us-east-2.amazonaws.com/"

    // Creating Retrofit instance
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Creating ApiService instance
    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
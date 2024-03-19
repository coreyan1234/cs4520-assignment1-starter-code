package com.cs4520.assignment1.data

import com.cs4520.assignment1.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("prod/{page}")
    suspend fun getProducts(@Query("page") page: Int = 3): List<Product>
}
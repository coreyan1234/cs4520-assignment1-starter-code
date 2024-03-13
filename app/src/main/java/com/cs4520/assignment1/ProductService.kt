package com.cs4520.assignment1

import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("/products")
    suspend fun getProducts(): Response<List<Product>>
}
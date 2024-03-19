package com.cs4520.assignment1.model

import androidx.lifecycle.LiveData
import com.cs4520.assignment1.Product

interface ProductRepository {
    suspend fun refreshProducts()

    fun getData(): LiveData<List<Product>>

    fun error(): LiveData<String>
}
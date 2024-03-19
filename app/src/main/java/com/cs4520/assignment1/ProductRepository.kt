package com.cs4520.assignment1

import androidx.lifecycle.LiveData
import androidx.room.Room
import com.cs4520.assignment1.data.ProductDao
import com.cs4520.assignment1.data.ProductDatabase
import com.cs4520.assignment1.data.RetrofitClient
import kotlin.coroutines.coroutineContext

class ProductRepository(private val productDao: ProductDao) {
    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun refreshProducts() {
        try {
            val products = RetrofitClient.apiService.getProducts()
            if (products.isNotEmpty()) {
                productDao.insertAll(products)
            }
            else {
                // TODO
            }
        } catch (e: Exception) {
            // Handle network error
        }
    }
}
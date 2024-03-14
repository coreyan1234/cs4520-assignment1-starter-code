package com.cs4520.assignment1

import androidx.lifecycle.LiveData
import com.cs4520.assignment1.data.ProductDao
import com.cs4520.assignment1.data.RetrofitClient

class ProductRepository(private val productDao: ProductDao) {
    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun refreshProducts(page: Int = 3) {
        try {
            val response = RetrofitClient.apiService.getProducts(page)
            if (response.isSuccessful) {
                val products = response.body()
                if (products != null) {
                    productDao.insertAll(products)
                }
            } else {
                // Handle error
            }
        } catch (e: Exception) {
            // Handle network error
        }
    }
}
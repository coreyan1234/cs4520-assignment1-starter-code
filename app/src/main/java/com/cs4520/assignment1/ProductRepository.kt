package com.cs4520.assignment1

import androidx.lifecycle.LiveData

class ProductRepository(private val productDao: ProductDao) {
    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

//    suspend fun refreshProducts(page: Int = 1) {
//        try {
//            val response = RetrofitClient.apiService.getProducts(page)
//            if (response.isSuccessful) {
//                val products = response.body()
//                products?.let {
//                    productDao.insertAll(it)
//                }
//            } else {
//                // Handle error
//            }
//        } catch (e: Exception) {
//            // Handle network error
//        }
//    }
}
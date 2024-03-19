package com.cs4520.assignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.cs4520.assignment1.data.ProductDao
import com.cs4520.assignment1.data.ProductDatabase
import com.cs4520.assignment1.data.RetrofitClient
import com.cs4520.assignment1.model.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class ProductRepositoryImpl(private val productDao: ProductDao): ProductRepository {
    private val error = MutableLiveData<String>()

    override suspend fun refreshProducts() {
        try {
            val products = RetrofitClient.apiService.getProducts()
            if (products.isNotEmpty()) {
                productDao.insertAll(products)
            }
        } catch (e: Exception) {
            // Handle network error
            error.value = "Network Error"
        }
    }

    override fun getData(): LiveData<List<Product>> = productDao.getLiveData()

    override fun error() = error
}
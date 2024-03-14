package com.cs4520.assignment1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class ProductViewModel(private val repository: ProductRepository): ViewModel() {
//    val allProducts: LiveData<List<Product>> = repository.allProducts

    fun refreshProducts(page: Int = 3) {
//        viewModelScope.launch {
//            repository.refreshProducts(page)
//        }
//        val apiService = RetrofitClient.apiService

        // Launching a new coroutine
        CoroutineScope(Dispatchers.IO).launch {
            repository.refreshProducts(3)
        }
    }
}
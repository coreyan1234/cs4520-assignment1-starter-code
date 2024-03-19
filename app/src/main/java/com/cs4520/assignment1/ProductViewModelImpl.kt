package com.cs4520.assignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs4520.assignment1.model.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModelImpl(private val repository: ProductRepository): ViewModel() {
    fun refreshProducts() {
        // Launching a new coroutine
        viewModelScope.launch(Dispatchers.IO) {
            repository.refreshProducts()
        }
    }

    fun getData() = repository.getData()

    fun error() = repository.error()
}
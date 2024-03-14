package com.cs4520.assignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository): ViewModel() {
    val allProducts: LiveData<List<Product>> = repository.allProducts

    fun refreshProducts(page: Int = 3) {
        viewModelScope.launch {
            repository.refreshProducts(page)
        }
    }
}
package com.cs4520.assignment1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Check if the requested ViewModel is assignable from MainViewModel
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            // If it is, create a ProductViewModel instance and pass the repository to its constructor
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(repository) as T
        }
        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
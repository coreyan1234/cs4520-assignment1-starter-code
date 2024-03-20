package com.cs4520.assignment1.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment1.ProductViewModelImpl

class ProductViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.AndroidViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModelImpl::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductViewModelImpl(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
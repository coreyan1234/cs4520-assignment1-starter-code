package com.cs4520.assignment1.data

import com.cs4520.assignment1.Product

data class ProductResponse (
    val products: List<Product>,
    val message: String
)

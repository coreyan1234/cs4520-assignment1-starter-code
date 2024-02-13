package com.cs4520.assignment1

sealed class Product {
    abstract val name: String
    abstract val productType: String
    abstract val expiryDate: String?
    abstract val price: Int
    data class Equipment(override val name: String, override val productType: String,
                         override val expiryDate: String?, override val price: Int) : Product()
    data class Food(override val name: String, override val productType: String,
                    override val expiryDate: String?, override val price: Int) : Product()
}
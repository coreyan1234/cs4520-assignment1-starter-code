package com.cs4520.assignment1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
sealed class Product {
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    abstract val name: String
    abstract val productType: String
    abstract val expiryDate: String?
    abstract val price: Double

    data class Equipment(override val name: String, override val productType: String,
                         override val expiryDate: String?, override val price: Double) : Product()
    data class Food(override val name: String, override val productType: String,
                    override val expiryDate: String?, override val price: Double) : Product()
}
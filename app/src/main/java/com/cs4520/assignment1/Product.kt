package com.cs4520.assignment1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val productType: String,
    val expiryDate: String?,
    val price: Double
)
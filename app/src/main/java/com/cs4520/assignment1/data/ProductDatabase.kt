package com.cs4520.assignment1.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cs4520.assignment1.Product

class ProductDatabase {
    @Database(entities = [Product::class], version = 1)
    abstract class ProductDatabase : RoomDatabase() {
        abstract fun productDao(): ProductDao
    }
}
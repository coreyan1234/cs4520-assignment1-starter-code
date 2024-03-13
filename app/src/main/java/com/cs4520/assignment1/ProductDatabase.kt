package com.cs4520.assignment1

import androidx.room.Database
import androidx.room.RoomDatabase

class ProductDatabase {
    @Database(entities = [Product::class], version = 1)
    abstract class ProductDatabase : RoomDatabase() {
        abstract fun productDao(): ProductDao
    }
}
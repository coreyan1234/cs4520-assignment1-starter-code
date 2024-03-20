package com.cs4520.assignment1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cs4520.assignment1.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

//    companion object {
//        @Volatile
//        private var INSTANCE: ProductDatabase? = null
//
//        fun getInstance(context: Context): ProductDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ProductDatabase::class.java,
//                    "product_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}
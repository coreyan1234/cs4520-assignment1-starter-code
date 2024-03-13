package com.cs4520.assignment1


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy

interface ProductDao {
    @Dao
    interface ProductDao {
        @Query("SELECT * FROM product")
        fun getAllProducts(): LiveData<List<Product>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAll(products: List<Product>)
    }
}
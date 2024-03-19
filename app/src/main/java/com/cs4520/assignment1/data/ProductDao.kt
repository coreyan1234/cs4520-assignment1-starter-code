package com.cs4520.assignment1.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy
import com.cs4520.assignment1.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Product>)

    @Query("SELECT * FROM product")
    fun getLiveData(): LiveData<List<Product>>
}
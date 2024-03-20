package com.cs4520.assignment1.data

import android.content.Context
import androidx.room.Room

object ProductDatabaseProvider {
    private var instance: ProductDatabase? = null
    private var appContext: Context? = null

    fun init(context:Context) {
        // Store the app context
        appContext = context.applicationContext
    }

    fun getInstance(): ProductDatabase {
        return instance ?: synchronized(this) {
            instance ?: buildDatabase(appContext).also { instance = it }
        }
    }

    private fun buildDatabase(context: Context?): ProductDatabase {
        if (context != null) {
            return Room.databaseBuilder(
                context.applicationContext,
                ProductDatabase::class.java,
                "product_database"
            ).build()
        }
        else {
            throw IllegalStateException("Context is null. Cannot build database.")
        }
    }
}
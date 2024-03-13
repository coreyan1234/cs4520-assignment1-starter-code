package com.cs4520.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cs4520.assignment1.fragments.LoginFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .commit()
        }

        val productService = RetrofitHelper.getInstance().create(ProductService::class.java)
        // Launching a new coroutine
        CoroutineScope(Dispatchers.IO).launch {
            val response = productService.getProducts()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        Log.d("Response is Successful: ", response.body().toString())
                    }
                    else {
                        Log.d("Response Unsuccessful", response.body().toString())
                    }
                }
                catch (e: HttpException) {
                    Log.d("HttpException: ${e.message()}", response.body().toString())
                }
                catch (e: Throwable) {
                    Log.d("Something else went wrong", response.body().toString())
                }
            }
        }
    }
}
package com.cs4520.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment1.data.ProductDao
import com.cs4520.assignment1.data.ProductDatabase
import com.cs4520.assignment1.data.ProductDatabaseProvider
import com.cs4520.assignment1.databinding.ActivityMainBinding
import com.cs4520.assignment1.fragments.LoginFragment
import com.cs4520.assignment1.fragments.ProductListFragment
import com.cs4520.assignment1.model.ProductViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ProductViewModelImpl
    private val adapter = ProductsAdapter()
    private lateinit var binding: ActivityMainBinding
    private lateinit var productDao: ProductDao

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Initialize ProductDao using ProductDatabase
//        productDao = ProductDatabase.getInstance(applicationContext).productDao()
//        val productRepository = ProductRepositoryImpl(productDao)
//        viewModel = ViewModelProvider(this)[ProductViewModelImpl::class.java]
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, LoginFragment())
//                .commit()
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ProductDatabaseProvider.init(applicationContext)
        val productDatabase = ProductDatabaseProvider.getInstance()
        productDao = productDatabase.productDao()

//        viewModel = ViewModelProvider(this, ProductViewModelFactory(ProductRepositoryImpl(productDao)))[ProductViewModelImpl::class.java]
        viewModel = ViewModelProvider(this)[ProductViewModelImpl(ProductRepositoryImpl(productDao))::class.java]

        // Replace the fragment container with the desired initial fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .commit()
        }
    }
}
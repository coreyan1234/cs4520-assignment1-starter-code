package com.cs4520.assignment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs4520.assignment1.ProductRepositoryImpl
import com.cs4520.assignment1.ProductViewModelImpl
import com.cs4520.assignment1.ProductsAdapter
import com.cs4520.assignment1.data.ProductDao
import com.cs4520.assignment1.data.ProductDatabase
import com.cs4520.assignment1.data.ProductDatabaseProvider
import com.cs4520.assignment1.databinding.FragmentProductListBinding
import com.cs4520.assignment1.model.ProductViewModelFactory


/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {
    private lateinit var viewModel: ProductViewModelImpl
    private lateinit var adapter: ProductsAdapter
    private lateinit var productDao: ProductDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductListBinding.inflate(inflater, container, false)
        val view = binding.root
        val recyclerView = binding.recyclerViewProducts

        adapter = ProductsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

//        viewModel = ViewModelProvider(this, ProductViewModelFactory(ProductRepositoryImpl(productDao)))[ProductViewModelImpl::class.java]
        val productDatabase = ProductDatabaseProvider.getInstance()
        productDao = productDatabase.productDao()
        viewModel = ViewModelProvider(this)[ProductViewModelImpl(ProductRepositoryImpl(productDao))::class.java]
        viewModel.getData().observe(viewLifecycleOwner) {
            recyclerView.visibility = View.VISIBLE
            adapter.submitList(it)
        }
        viewModel.error().observe(viewLifecycleOwner) {
            // hide recycler view
            // show the error text view
            // set the value on error text view
            recyclerView.visibility = View.GONE
            binding.error.visibility = View.VISIBLE
        }

        viewModel.refreshProducts()

        return view
    }
}
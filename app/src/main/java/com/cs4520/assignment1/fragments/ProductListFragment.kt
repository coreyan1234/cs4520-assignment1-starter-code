package com.cs4520.assignment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.Product
import com.cs4520.assignment1.ProductDiffCallback
import com.cs4520.assignment1.ProductViewModel
import com.cs4520.assignment1.ProductsAdapter
import com.cs4520.assignment1.databinding.FragmentProductListBinding

import com.cs4520.assignment1.productsDataset


/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {
    private lateinit var viewModel: ProductViewModel
    private lateinit var adapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductListBinding.inflate(inflater, container, false)
        val view = binding.root

        val recyclerView = binding.recyclerViewProducts
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ProductsAdapter()
        recyclerView.adapter = adapter

//        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        viewModel.allProducts.observe(viewLifecycleOwner, Observer { products ->
            if (products != null) {
                adapter.submitList(products)
            }
        })

        viewModel.refreshProducts()

        return view
    }
}
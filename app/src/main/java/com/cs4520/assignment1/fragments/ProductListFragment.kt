package com.cs4520.assignment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs4520.assignment1.ProductViewModelImpl
import com.cs4520.assignment1.ProductsAdapter
import com.cs4520.assignment1.databinding.FragmentProductListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {
    private lateinit var viewModel: ProductViewModelImpl
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

        viewModel = ViewModelProvider(this)[ProductViewModelImpl::class.java]
        viewModel.getData().observe(viewLifecycleOwner) {
            recyclerView.visibility = View.VISIBLE
            adapter.submitList(it)
        }
        viewModel.error().observe(viewLifecycleOwner) {
            // hide recycler view
            // show the error text view
            // set the value on error text view
            recyclerView.visibility = View.GONE

        }

        viewModel.refreshProducts()

        return view
    }
}
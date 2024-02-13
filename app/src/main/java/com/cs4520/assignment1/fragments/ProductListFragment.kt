package com.cs4520.assignment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.ProductsAdapter
import com.cs4520.assignment1.R
import com.cs4520.assignment1.productsDataset

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ProductsAdapter(productsDataset)

        return view
    }
}
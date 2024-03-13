package com.cs4520.assignment1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.Product
import com.cs4520.assignment1.ProductsAdapter
import com.cs4520.assignment1.databinding.FragmentProductListBinding

import com.cs4520.assignment1.productsDataset


/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {
    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        val view = binding.root

        val recyclerView = binding.recyclerViewProducts
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val productList = generateProductList()
        recyclerView.adapter = ProductsAdapter(productList)

        return view
    }

    private fun generateProductList(): List<Product> {
        val productList = mutableListOf<Product>()
        for (product in productsDataset) {
            val name = product[0] as String
            val type = product[1] as String
            val expiryDate = product[2] as? String
            val price = product[3] as Double

            if (type == "Equipment") {
                productList.add(Product.Equipment(name, type, expiryDate, price))
            }
            else if (type == "Food") {
                productList.add(Product.Food(name, type, expiryDate, price))
            }
        }
        return productList
    }
}
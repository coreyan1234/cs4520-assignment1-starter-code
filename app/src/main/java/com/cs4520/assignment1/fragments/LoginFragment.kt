package com.cs4520.assignment1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.cs4520.assignment1.R
import com.cs4520.assignment1.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

//        val view = inflater.inflate(R.layout.fragment_login, container, false)

//        val usernameField = view.findViewById<EditText>(R.id.usernameField)
//        val passwordField = view.findViewById<EditText>(R.id.passwordField)
//        val loginButton = view.findViewById<Button>(R.id.buttonLogin)

        binding.buttonLogin.setOnClickListener {
            val username = binding.usernameField.text.toString()
            val password = binding.passwordField.text.toString()
            if (username == "admin" && password == "admin") {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_productListFragment)
            }
            else {
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
            binding.usernameField.text.clear()
            binding.passwordField.text.clear()
        }

//        loginButton.setOnClickListener {
//            val username = usernameField.text.toString()
//            val password = passwordField.text.toString()
//
//            if (username == "admin" && password == "admin") {
//                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_productListFragment)
//            }
//            else {
//                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
//            }
//
//            usernameField.text.clear()
//            passwordField.text.clear()
//        }

        return view
    }
}
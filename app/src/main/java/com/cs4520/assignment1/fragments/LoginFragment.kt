package com.cs4520.assignment1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment1.R

class LoginFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val usernameField = view.findViewById<EditText>(R.id.usernameField)
        val passwordField = view.findViewById<EditText>(R.id.passwordField)
        val loginButton = view.findViewById<Button>(R.id.buttonLogin)

        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (username == "admin" && password == "admin") {
                findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
            }
            else {
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
            }

            usernameField.text.clear()
            passwordField.text.clear()
        }

        return view
    }
}
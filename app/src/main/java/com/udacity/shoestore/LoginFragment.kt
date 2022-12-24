package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

//
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nn = binding.editTextTextEmailAddress.text.toString()
        binding.button.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWolcomeFragment())

        }
        binding.button2.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWolcomeFragment())
        }


    }

}
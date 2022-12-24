package com.udacity.shoestore

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentNewShoeBinding
import kotlinx.android.synthetic.*

class newShoeFragment : Fragment() {

    lateinit var binding: FragmentNewShoeBinding
    lateinit var viewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoe, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)
        binding.model = viewModel

        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonCancel.setOnClickListener {

            findNavController().navigate(
                newShoeFragmentDirections.actionNewShoeFragmentToShoeListFragment()
            )


        }

        binding.buttonSave.setOnClickListener {
            viewModel.addShoe()
            findNavController().navigate(
                newShoeFragmentDirections.actionNewShoeFragmentToShoeListFragment(
                )
            )

        }
    }

}
package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeCardBinding
import com.udacity.shoestore.models.Shoe


class shoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding

    lateinit var viewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//to extract the date from view model list
        viewModel.shoes.observe(viewLifecycleOwner) { list ->
            list.forEach {
                binding.te.addView(addShoeView(it))

            }
        }


        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(shoeListFragmentDirections.actionShoeListFragmentToNewShoeFragment())
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    fun addShoeView(shoe: Shoe): View {
        val inflater = LayoutInflater.from(requireContext())
        val shoeBindingView = ShoeCardBinding.inflate(inflater, null, false)
        shoeBindingView.textViewCompany.text = shoe.company
        shoeBindingView.textViewShoeName.text = shoe.name
        shoeBindingView.textViewSize.text = shoe.size
        shoeBindingView.textViewDescription.text = shoe.description
        return shoeBindingView.root
    }

}
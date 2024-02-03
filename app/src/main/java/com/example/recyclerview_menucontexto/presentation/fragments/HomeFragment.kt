package com.example.recyclerview_menucontexto.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recyclerview_menucontexto.presentation.adapters.ProductAdapter
import com.example.recyclerview_menucontexto.presentation.viewmodel.ProductViewModel
import com.example.recyclerview_menucontexto.R
import com.example.recyclerview_menucontexto.commons.extensions.configureToolbar
import com.example.recyclerview_menucontexto.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).configureToolbar("Home", false)
        activity?.findViewById<BottomNavigationView>(R.id.bottomMenu)?.visibility = View.VISIBLE
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        with(binding) {
            val items = productViewModel.getProducts()

            this.adapter = ProductAdapter(items) {
                val bundle = bundleOf("product" to it)
                findNavController().navigate(R.id.action_homeFragment_to_detailProductFragment, bundle)
            }
        }
    }
}
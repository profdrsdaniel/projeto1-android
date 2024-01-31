package com.example.recyclerview_menucontexto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    private lateinit var adapter: ProductAdapter
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).configureToolbar("Home", false)
        activity?.findViewById<BottomNavigationView>(R.id.bottomMenu)?.visibility = View.VISIBLE
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        // Recyclerview
        val recycler = view.findViewById<RecyclerView>(R.id.rcListOfProducts)
        val items = productViewModel.getProducts()

        adapter = ProductAdapter(items) {
            val bundle = bundleOf("product" to it)
            findNavController().navigate(R.id.action_homeFragment_to_detailProductFragment, bundle)
        }

        recycler.adapter = adapter
    }
}
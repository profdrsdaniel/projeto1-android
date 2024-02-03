package com.example.recyclerview_menucontexto.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.R
import com.example.recyclerview_menucontexto.commons.extensions.configureToolbar
import com.example.recyclerview_menucontexto.databinding.FragmentDetailProductBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailProductFragment : Fragment() {

    private lateinit var binding: FragmentDetailProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productBundle = arguments?.getSerializable("product", Product::class.java)

        (requireActivity() as AppCompatActivity).configureToolbar("Detalhe", true)

        activity?.findViewById<BottomNavigationView>(R.id.bottomMenu)?.visibility = View.GONE

        with(binding) {
            this.product = productBundle
        }
    }
}
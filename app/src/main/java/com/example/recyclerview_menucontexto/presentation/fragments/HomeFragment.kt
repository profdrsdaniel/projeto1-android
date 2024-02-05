package com.example.recyclerview_menucontexto.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recyclerview_menucontexto.presentation.adapters.ProductAdapter
import com.example.recyclerview_menucontexto.presentation.viewmodel.ProductViewModel
import com.example.recyclerview_menucontexto.R
import com.example.recyclerview_menucontexto.commons.Result
import com.example.recyclerview_menucontexto.commons.extensions.configureToolbar
import com.example.recyclerview_menucontexto.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Chama os produtos
        productViewModel.getProducts()

        (requireActivity() as AppCompatActivity).configureToolbar("Home", false)
        activity?.findViewById<BottomNavigationView>(R.id.bottomMenu)?.visibility = View.VISIBLE

        // Observa a mudança do livedata
        productViewModel.products.observe(viewLifecycleOwner) { result ->
            with(binding) {
                when (result) {
                    is Result.Loading -> {
                        this.progress.visibility = View.VISIBLE
                    }

                    is Result.Success -> {
                        this.adapter = ProductAdapter(
                            items = result.data.orEmpty(),
                            deleteProduct = { name ->
                                productViewModel.deleteProduct(name)
                            }
                        ) {

                            val bundle = bundleOf("product" to it)
                            findNavController().navigate(
                                R.id.action_homeFragment_to_detailProductFragment,
                                bundle
                            )
                        }

                        this.progress.visibility = View.GONE
                    }

                    is Result.Error -> {
                        Toast.makeText(context, "Um Erro Ocorreu", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
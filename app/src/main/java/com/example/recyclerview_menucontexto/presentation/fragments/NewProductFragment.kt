package com.example.recyclerview_menucontexto.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.recyclerview_menucontexto.commons.extensions.configureToolbar
import com.example.recyclerview_menucontexto.databinding.FragmentNewProductBinding
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.presentation.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewProductFragment : Fragment() {

    private val productViewModel: ProductViewModel by viewModels()
    private lateinit var binding: FragmentNewProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewProductBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).configureToolbar("Novo Produto", false)

        with(binding) {
            this.button.setOnClickListener {
                val productName = this.nameProduct.text
                val productPrice = this.priceProduct.text
                val productImg = this.imgUrl.text

                productViewModel.addProduct(
                    Product(
                        name = productName.toString(),
                        price = productPrice.toString(),
                        urlImage = productImg.toString()
                    )
                )

                productName.clear()
                productPrice.clear()
                productImg.clear()

                Toast.makeText(context, "Produto adicionado com sucesso...", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
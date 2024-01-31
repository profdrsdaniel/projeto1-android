package com.example.recyclerview_menucontexto

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailProductFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_product, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productBundle = arguments?.getSerializable("product", Product::class.java)

        (requireActivity() as AppCompatActivity).configureToolbar("Detalhe", true)

        activity?.findViewById<BottomNavigationView>(R.id.bottomMenu)?.visibility = View.GONE

        val name = view.findViewById<TextView>(R.id.tvProductName)
        val price = view.findViewById<TextView>(R.id.tvProductPrice)
        val image = view.findViewById<ImageView>(R.id.imgProduct)

        Glide.with(this)
            .load(productBundle?.urlImage)
            .centerCrop()
            .into(image)
        name.text = productBundle?.name
        price.text = productBundle?.price?.convertToMoneyWithSymbol()
    }
}
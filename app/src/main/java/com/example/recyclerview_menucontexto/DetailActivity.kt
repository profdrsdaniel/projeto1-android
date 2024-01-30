package com.example.recyclerview_menucontexto

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Recupera um produto passado por bundle
        val productBundle = intent.getSerializableExtra("data") as? Product

        val name = findViewById<TextView>(R.id.tvProductName)
        val price = findViewById<TextView>(R.id.tvProductPrice)
        val image = findViewById<ImageView>(R.id.imgProduct)

        Glide
            .with(this)
            .load(productBundle?.urlImage)
            .centerCrop()
            .into(image)


        name.text = productBundle?.name
        price.text = "R$ ${productBundle?.price}"
    }
}
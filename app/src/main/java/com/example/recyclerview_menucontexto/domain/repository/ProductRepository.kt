package com.example.recyclerview_menucontexto.domain.repository

import com.example.recyclerview_menucontexto.domain.model.Product

interface ProductRepository {
    fun getProducts(): List<Product>
}
package com.example.recyclerview_menucontexto.domain.repository

import com.example.recyclerview_menucontexto.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun addProduct(product: Product)
    suspend fun deleteProduct(name: String)
}
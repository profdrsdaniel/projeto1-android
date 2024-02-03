package com.example.recyclerview_menucontexto.data.repository

import com.example.recyclerview_menucontexto.data.local.ProductLocalDataSource
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.domain.repository.ProductRepository

class ProductRepositoryImpl(private val dataSource: ProductLocalDataSource = ProductLocalDataSource()) :
    ProductRepository {
    override fun getProducts(): List<Product> = dataSource.getProducts()
}
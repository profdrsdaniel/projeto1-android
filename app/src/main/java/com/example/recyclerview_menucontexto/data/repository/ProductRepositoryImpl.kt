package com.example.recyclerview_menucontexto.data.repository

import com.example.recyclerview_menucontexto.data.datasource.ProductLocalDataSource
import com.example.recyclerview_menucontexto.data.local.entities.ProductEntity
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productDataSource: ProductLocalDataSource) :
    ProductRepository {
    override suspend fun getProducts(): List<Product> = productDataSource.getProducts()

    override suspend fun addProduct(product: Product) = productDataSource.addProduct(product)

    override suspend fun deleteProduct(name: String) = productDataSource.deleteProduct(name)
}
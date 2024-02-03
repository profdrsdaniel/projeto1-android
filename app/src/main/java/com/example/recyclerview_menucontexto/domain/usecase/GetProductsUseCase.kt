package com.example.recyclerview_menucontexto.domain.usecase

import com.example.recyclerview_menucontexto.data.repository.ProductRepositoryImpl
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.domain.repository.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository = ProductRepositoryImpl()) {
    operator fun invoke(): MutableList<Product> {
        val listOfProducts: MutableList<Product> = mutableListOf()

        repository.getProducts().forEach {
            listOfProducts.add(it)
        }

        return listOfProducts
    }
}
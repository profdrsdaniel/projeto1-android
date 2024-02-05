package com.example.recyclerview_menucontexto.domain.usecase

import com.example.recyclerview_menucontexto.data.repository.ProductRepositoryImpl
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.domain.repository.ProductRepository
import javax.inject.Inject

class AddProductsUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(product: Product) = repository.addProduct(product)
}
package com.example.recyclerview_menucontexto.domain.usecase

import com.example.recyclerview_menucontexto.data.repository.ProductRepositoryImpl
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.domain.repository.ProductRepository
import javax.inject.Inject

class DeleteProductUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(name: String) = repository.deleteProduct(name)
}
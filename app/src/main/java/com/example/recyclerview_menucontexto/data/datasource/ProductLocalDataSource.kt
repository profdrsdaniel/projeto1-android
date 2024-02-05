package com.example.recyclerview_menucontexto.data.datasource

import com.example.recyclerview_menucontexto.commons.extensions.convertToMoneyWithSymbol
import com.example.recyclerview_menucontexto.data.local.dao.ProductDao
import com.example.recyclerview_menucontexto.data.local.entities.ProductEntity
import com.example.recyclerview_menucontexto.data.local.entities.toDomain
import com.example.recyclerview_menucontexto.data.local.entities.toEntity
import com.example.recyclerview_menucontexto.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductLocalDataSource @Inject constructor(private val productDao: ProductDao) {

    suspend fun addProduct(product: Product) = withContext(Dispatchers.IO) {
        productDao.addProduct(product = product.toEntity())
    }

    suspend fun getProducts(): List<Product> =
        withContext(Dispatchers.IO) {
            productDao.getAllProducts().map { product ->
                product.toDomain().copy(price = product.price.convertToMoneyWithSymbol())
            }
        }

    suspend fun deleteProduct(name: String) = withContext(Dispatchers.IO) {
        productDao.deleteProduct(name)
    }
}
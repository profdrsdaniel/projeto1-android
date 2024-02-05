package com.example.recyclerview_menucontexto.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.recyclerview_menucontexto.data.local.entities.ProductEntity

@Dao
interface ProductDao {
    @Insert
    suspend fun addProduct(product: ProductEntity)

    @Query("Select * from product ORDER by price DESC")
    suspend fun getAllProducts(): List<ProductEntity>

    @Query("Delete from product where name = :name")
    fun deleteProduct(name: String)
}
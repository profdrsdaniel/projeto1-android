package com.example.recyclerview_menucontexto.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recyclerview_menucontexto.domain.model.Product

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: String,
    val urlImage: String
)

fun ProductEntity.toDomain() =
    Product(name = this.name, price = this.price, urlImage = this.urlImage)

fun Product.toEntity() =
    ProductEntity(name = this.name, price = this.price, urlImage = this.urlImage)

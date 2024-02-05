package com.example.recyclerview_menucontexto.di

import com.example.recyclerview_menucontexto.data.datasource.ProductLocalDataSource
import com.example.recyclerview_menucontexto.data.local.dao.ProductDao
import com.example.recyclerview_menucontexto.domain.repository.ProductRepository
import com.example.recyclerview_menucontexto.domain.usecase.AddProductsUseCase
import com.example.recyclerview_menucontexto.domain.usecase.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesGetProductsUseCase(productRepository: ProductRepository): GetProductsUseCase {
        return GetProductsUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun providesAddProductUseCase(productRepository: ProductRepository): AddProductsUseCase {
        return AddProductsUseCase(productRepository)
    }
}
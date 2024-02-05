package com.example.recyclerview_menucontexto.di

import com.example.recyclerview_menucontexto.data.datasource.ProductLocalDataSource
import com.example.recyclerview_menucontexto.data.local.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesProductLocalDataSource(productDao: ProductDao): ProductLocalDataSource {
        return ProductLocalDataSource(productDao)
    }
}
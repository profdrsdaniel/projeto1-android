package com.example.recyclerview_menucontexto.di

import android.content.Context
import androidx.room.Room
import com.example.recyclerview_menucontexto.data.local.dao.ProductDao
import com.example.recyclerview_menucontexto.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "aula").build()
    }

    @Provides
    @Singleton
    fun providesProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao()
    }
}
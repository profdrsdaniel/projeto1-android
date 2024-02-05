package com.example.recyclerview_menucontexto.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recyclerview_menucontexto.data.local.dao.ProductDao
import com.example.recyclerview_menucontexto.data.local.entities.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
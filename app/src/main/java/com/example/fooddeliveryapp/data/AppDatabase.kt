package com.example.fooddeliveryapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Order::class, MenuItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
}
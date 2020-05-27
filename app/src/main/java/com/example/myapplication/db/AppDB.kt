package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DataEntity::class), version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun dataDao(): DataDao
}
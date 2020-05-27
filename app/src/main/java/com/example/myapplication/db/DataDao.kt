package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {
    @Insert
    fun insert(dataEntity: DataEntity)

    @Query("SELECT * FROM data ORDER BY id DESC")
    fun getAllData(): List<DataEntity>
}
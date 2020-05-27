package com.example.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
class DataEntity(
    @ColumnInfo(name = "email") val email: String? = null,
    @ColumnInfo(name = "id") val id: Int? = null,
    @ColumnInfo(name = "username") val username: String? = null,
    @PrimaryKey(autoGenerate = true) val id_punyaroom: Int? = null
)
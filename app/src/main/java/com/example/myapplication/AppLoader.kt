package com.example.myapplication

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.myapplication.db.AppDB
import com.example.myapplication.network.DataRepository
import com.example.myapplication.util.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class AppLoader : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        startKoin {
            androidContext(this@AppLoader)
            modules(module {
                single {
                    Room.databaseBuilder(applicationContext, AppDB::class.java, "MyDB")
                        .allowMainThreadQueries()
                        .build()
                }
                single { DataRepository.created() }
            })
            modules(myModule)
        }
    }
}
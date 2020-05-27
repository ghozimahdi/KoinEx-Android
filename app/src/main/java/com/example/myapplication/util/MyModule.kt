package com.example.myapplication.util

import com.example.myapplication.ui.main.MainPresenter
import com.example.myapplication.ui.register.RegisterPresenter
import org.koin.dsl.module

val myModule = module {
    factory { RegisterPresenter(get(), get()) }
    factory { MainPresenter(get()) }
}
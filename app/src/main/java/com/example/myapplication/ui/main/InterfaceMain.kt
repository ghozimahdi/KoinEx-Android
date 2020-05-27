package com.example.myapplication.ui.main

import com.example.myapplication.db.DataEntity

interface InterfaceMain {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun showData(dataEntity: DataEntity)
    }

    interface Presenter {
        fun fetchData()
    }
}
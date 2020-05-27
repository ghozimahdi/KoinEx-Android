package com.example.myapplication.ui.main

import com.example.myapplication.db.AppDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter(private val db: AppDB) : InterfaceMain.Presenter {
    var view: InterfaceMain.View? = null

    override fun fetchData() {
        view?.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            val entity = db.dataDao().getAllData()[0]
            launch {
                view?.showData(entity)
                view?.hideLoading()
            }
        }
    }
}
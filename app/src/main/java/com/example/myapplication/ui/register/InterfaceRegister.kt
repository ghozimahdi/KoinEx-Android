package com.example.myapplication.ui.register

import com.example.myapplication.model.BodyRegister

interface InterfaceRegister {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun onError(msg: String)
        fun onSuccess(msg: String)
    }

    interface Presenter {
        fun register(bodyRegister: BodyRegister)
    }
}
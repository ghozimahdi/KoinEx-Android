package com.example.myapplication.ui.register

import android.util.Log
import com.example.myapplication.db.AppDB
import com.example.myapplication.db.DataEntity
import com.example.myapplication.model.BodyRegister
import com.example.myapplication.model.ResponseRegister
import com.example.myapplication.network.ApiServices
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(
    private val apiServices: ApiServices,
    private val appDB: AppDB
) : InterfaceRegister.Presenter {
    private val TAG = "RegisterPresenter"
    var view: InterfaceRegister.View? = null

    override fun register(bodyRegister: BodyRegister) {
        view?.showLoading()
        apiServices.register(bodyRegister).enqueue(object : Callback<ResponseRegister> {
            override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                Log.d(TAG, t.message.toString())
                view?.onError(t.message.toString())
                view?.hideLoading()
            }

            override fun onResponse(
                call: Call<ResponseRegister>,
                response: Response<ResponseRegister>
            ) {
                if (response.code() == 201 || response.code() == 200) {
                    val model = response.body()
                    GlobalScope.launch {
                        appDB.dataDao()
                            .insert(
                                DataEntity(
                                    email = model?.data?.email,
                                    username = model?.data?.username,
                                    id = model?.data?.id
                                )
                            )
                    }
                    view?.onSuccess(model?.message.toString())
                } else {
                    val model = response.body()
                    view?.onError("Register Failed!")
                }
                view?.hideLoading()
            }

        })
    }
}
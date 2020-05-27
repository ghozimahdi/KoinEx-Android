package com.example.myapplication.network

import com.example.myapplication.model.BodyRegister
import com.example.myapplication.model.ResponseRegister
import com.example.myapplication.util.REGISTER
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {
    @POST(REGISTER)
    fun register(@Body bodyRegister: BodyRegister): Call<ResponseRegister>
}
package com.example.sopt26seminar3.network

import com.example.sopt26seminar3.data.RequestLogin
import com.example.sopt26seminar3.data.RequestRegister
import com.example.sopt26seminar3.data.ResponseLogin
import com.example.sopt26seminar3.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestRegister(@Body body: RequestRegister) : Call<ResponseRegister>
}
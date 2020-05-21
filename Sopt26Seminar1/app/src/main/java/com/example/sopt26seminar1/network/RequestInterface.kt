package com.example.sopt26seminar1

import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin) : 
}
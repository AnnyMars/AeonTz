package com.example.aeontz.data.remote

import com.example.aeontz.data.remote.model.LoginBody
import com.example.aeontz.data.remote.model.ResponseModel
import com.example.aeontz.data.remote.model.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {


    @GET("payments")
    suspend fun getPayments(@Header("token") token: String): ResponseModel



    @POST("login")
    suspend fun postLogin(@Body request: LoginBody): TokenResponse

}
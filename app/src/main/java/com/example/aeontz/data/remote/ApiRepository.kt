package com.example.aeontz.data.remote

import android.content.SharedPreferences
import com.example.aeontz.data.remote.model.LoginBody
import com.example.aeontz.data.remote.model.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val api: ApiService,
    private val pref: SharedPreferences
) {

    suspend fun makePost(login: String, password: String){
        val postResponse = api.postLogin(LoginBody(login, password))
        val token = postResponse.response.token
        saveTokenToSharedPreferences(token)
    }

    private fun saveTokenToSharedPreferences(token: String) {
        pref.edit().putString("token", token).apply()
    }

    suspend fun getPayments(token: String): List<Response> {
        return api.getPayments(token).response
    }



}
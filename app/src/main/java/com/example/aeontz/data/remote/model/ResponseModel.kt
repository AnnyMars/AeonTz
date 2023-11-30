package com.example.aeontz.data.remote.model


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("response")
    val response: List<Response>,
    @SerializedName("success")
    val success: String
)
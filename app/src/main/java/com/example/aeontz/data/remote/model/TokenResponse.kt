package com.example.aeontz.data.remote.model


import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("response")
    val response: ResponseX,
    @SerializedName("success")
    val success: String
)
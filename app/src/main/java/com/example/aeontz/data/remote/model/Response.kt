package com.example.aeontz.data.remote.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("amount")
    val amount: String?,
    @SerializedName("created")
    val created: Int?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)
package com.example.retrofit.Model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("userId") val userId: String,
    @SerializedName("id")val id : String,
    @SerializedName("title")val title : String,
    @SerializedName("body")val body : String
)
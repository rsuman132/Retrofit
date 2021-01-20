package com.example.retrofit.Interface

import com.example.retrofit.Model.Data
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

interface RetrofitService {
    @GET("posts")
    fun getDataList() : Call<ArrayList<Data>>
}

object RetrofitClients{
    val retrofitService : RetrofitService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitService = retrofit.create(RetrofitService::class.java)
    }

}
package com.zsondroid.mvvmapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val BASE_URL = "https://emojihub.yurace.pro/api/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: RetrofitInterface by lazy {
        retrofit.create(RetrofitInterface::class.java)
    }
}
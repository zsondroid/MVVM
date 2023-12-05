package com.zsondroid.mvvmapplication.network

import com.zsondroid.mvvmapplication.data.Emoji
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("random")
    suspend fun getRandomEmojiData(): Emoji
}
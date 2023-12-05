package com.zsondroid.mvvmapplication.model

import com.zsondroid.mvvmapplication.network.RetrofitInstance

class MainRepositoryRetrofit {
    suspend fun getRandomEmojiData() = RetrofitInstance.api.getRandomEmojiData()

}
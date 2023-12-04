package com.zsondroid.mvvmapplication.model

class MainRepository {
    private val testData: String = "zsondroid test"

    fun getTestData(): String {
        return testData
    }
}
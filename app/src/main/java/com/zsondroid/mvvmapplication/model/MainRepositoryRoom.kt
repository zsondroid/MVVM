package com.zsondroid.mvvmapplication.model

import android.content.Context
import com.zsondroid.mvvmapplication.room.User
import com.zsondroid.mvvmapplication.room.UserDatabase

class MainRepositoryRoom(context: Context) {
    private val userDatabase = UserDatabase.getDBInstance(context)
    private val userDao = userDatabase?.userDao()

    fun getAll() = userDao?.selectAll()

    fun insert(user: User) {
        try {
            userDao?.insert(user)
        } catch (_: Exception) {
        }
    }

    fun delete(user: User) {
        try {
            userDao?.delete(user)
        } catch (_: Exception) {

        }
    }
}
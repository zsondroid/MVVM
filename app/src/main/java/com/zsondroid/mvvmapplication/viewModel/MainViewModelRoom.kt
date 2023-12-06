package com.zsondroid.mvvmapplication.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zsondroid.mvvmapplication.model.MainRepositoryRoom
import com.zsondroid.mvvmapplication.room.User
import kotlinx.coroutines.*

class MainViewModelRoom(context: Context) : ViewModel() {
    private val mainRepositoryRoom = MainRepositoryRoom(context)

    private val _userData= MutableLiveData<List<User>>()
    val userData: LiveData<List<User>> get() = _userData

    fun getAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val resultUserData = mainRepositoryRoom.getAll()

            withContext(Dispatchers.Main) {
                _userData.value = resultUserData
            }
        }
    }

    fun insert(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepositoryRoom.insert(user)
        }
    }

    fun delete(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepositoryRoom.delete(user)
        }
    }
}
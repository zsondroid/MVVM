package com.zsondroid.mvvmapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zsondroid.mvvmapplication.model.MainRepositoryRoom
import com.zsondroid.mvvmapplication.room.User
import kotlinx.coroutines.*

class MainViewModelRoom(val mainRepository: MainRepositoryRoom) : ViewModel() {
    private val _userData= MutableLiveData<List<User>>()
    val userData: LiveData<List<User>> get() = _userData

    fun getAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val resultUserData = mainRepository.getAll()

            withContext(Dispatchers.Main) {
                _userData.value = resultUserData
            }
        }
    }

    fun insert(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.insert(user)
        }
    }

    fun delete(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.delete(user)
        }
    }
}
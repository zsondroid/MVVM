package com.zsondroid.mvvmapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zsondroid.mvvmapplication.model.MainRepository

class MainViewModel : ViewModel() {
    private val mainRepository = MainRepository()

    private val _testData = MutableLiveData<String>("")
    val testData: LiveData<String> get() = _testData

    fun setTestData() {
        _testData.value = mainRepository.getTestData()
    }
}
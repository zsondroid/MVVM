package com.zsondroid.mvvmapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zsondroid.mvvmapplication.R
import com.zsondroid.mvvmapplication.databinding.ActivityMainBinding
import com.zsondroid.mvvmapplication.room.User
import com.zsondroid.mvvmapplication.viewModel.MainViewModelRetrofit
import com.zsondroid.mvvmapplication.viewModel.MainViewModelRoom

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModelRetrofit: MainViewModelRetrofit
    private val mainViewModelRoom : MainViewModelRoom by viewModels {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                MainViewModelRoom(application) as T
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModelRetrofit = ViewModelProvider(this)[MainViewModelRetrofit::class.java]

        binding.lifecycleOwner = this
        binding.mainViewModelRetrofit = mainViewModelRetrofit
        binding.mainViewModelRoom = mainViewModelRoom

        // 테스트 User 데이터 생성 후 INSERT
        val user = User("마루", "5", "010-1234-1234")
        mainViewModelRoom.insert(user)

        setDataObserver()
    }

    private fun setDataObserver() {
        mainViewModelRetrofit.emojiData.observe(this) {
            binding.tvTextEmoji.text = it.name
        }

        mainViewModelRoom.userData.observe(this) {
            binding.tvTextRoom.text = it.toString()
        }
    }
}
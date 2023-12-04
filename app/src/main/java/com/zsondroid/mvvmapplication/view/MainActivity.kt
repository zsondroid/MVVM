package com.zsondroid.mvvmapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.zsondroid.mvvmapplication.R
import com.zsondroid.mvvmapplication.databinding.ActivityMainBinding
import com.zsondroid.mvvmapplication.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.lifecycleOwner = this
        binding.mainViewModel = mainViewModel
    }
}
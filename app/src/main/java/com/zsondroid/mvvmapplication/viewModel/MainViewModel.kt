package com.zsondroid.mvvmapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zsondroid.mvvmapplication.data.Emoji
import com.zsondroid.mvvmapplication.model.MainRepositoryRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val mainRepositoryRetrofit = MainRepositoryRetrofit()

    // MutableLiveData 는 수정 가능
    private val _emojiData = MutableLiveData<Emoji>()

    // LiveData 는 외부에서 수정 불가능하게 설정
    // getter 를 사용하여 데이터를 읽는 과정만 수행 가능
    val emojiData: LiveData<Emoji>
        get() = _emojiData

    // LiveData 를 수정하는 함수
    fun setRandomEmojiData() {
        var resultEmojiData: Emoji

        viewModelScope.launch(Dispatchers.IO) {
            resultEmojiData = mainRepositoryRetrofit.getRandomEmojiData()

            withContext(Dispatchers.Main) {
                _emojiData.value = resultEmojiData
            }
        }
    }
}
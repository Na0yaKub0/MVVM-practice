package com.example.mvvm.sub

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SubViewModel(intent: Intent)  : ViewModel(){

    // ViewModelに引数を追加する設定
    class Factory constructor(
        private val intent: Intent
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            SubViewModel(intent) as T
    }

    companion object {
        const val SEND_MESSAGE = "SEND_MESSAGE"
    }

    private val _textViewStr: MutableLiveData<String> by lazy { MutableLiveData<String>("")}
    val textViewStr: LiveData<String> = _textViewStr

    // 起動時の処理
    init {
        _textViewStr.value = intent.getStringExtra(SEND_MESSAGE)
    }
}
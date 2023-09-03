package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val _textViewStr: MutableLiveData<String> by lazy { MutableLiveData<String>("")}
    val textViewStr: LiveData<String> = _textViewStr

    //　ボタンをクリックしたときの処理
    fun onClickButton(text: String) {
        _textViewStr.value = text
    }
}
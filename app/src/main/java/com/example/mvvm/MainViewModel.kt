package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val _cnt: MutableLiveData<Int> by lazy { MutableLiveData<Int>(0)}
    val cnt: LiveData<Int> = _cnt

    // Activity側のボタンが押された時の処理
    fun onClickActivityButton() {
        _cnt.value = _cnt.value?.plus(1)
    }

    // Fragment側のボタンが押された時の処理
    fun onClickFragmentButton() {
        _cnt.value = _cnt.value?.plus(10)
    }
}
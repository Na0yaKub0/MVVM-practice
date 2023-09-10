package com.example.mvvm.main

import androidx.lifecycle.*
import com.example.mvvm.main.live_data.Event

class MainViewModel : ViewModel(){

    private val _onMoveSubActivity: MutableLiveData<Event<String>> by lazy { MutableLiveData<Event<String>>()}
    val onMoveSubActivity: LiveData<Event<String>> = _onMoveSubActivity

    //　「移動する」をクリックしたときの処理
    fun onClickButton(text: String) {
        _onMoveSubActivity.value = Event(text)
    }
}

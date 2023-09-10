package com.example.mvvm.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.main.live_data.EventObserver
import com.example.mvvm.sub.SubActivity
import com.example.mvvm.sub.SubViewModel
import com.google.android.material.snackbar.Snackbar
import java.util.EventObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewBinding初期化
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // viewModel初期化
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.button.setOnClickListener {
            viewModel.onClickButton(binding.editTextText.text.toString())
        }

        // 画面遷移の処理
        viewModel.onMoveSubActivity.observe(this, EventObserver {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra(SubViewModel.SEND_MESSAGE, it)
            startActivity(intent)
        })
    }
}
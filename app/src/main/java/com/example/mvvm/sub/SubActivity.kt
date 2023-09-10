package com.example.mvvm.sub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    private lateinit var viewModel: SubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewBinding初期化
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // viewModel初期化
        viewModel = ViewModelProvider(this, SubViewModel.Factory(intent))[SubViewModel::class.java]

        //  LiveDataを読み込み反映
        viewModel.textViewStr.observe(this, Observer {
            binding.textView.text = it
        })

    }

}
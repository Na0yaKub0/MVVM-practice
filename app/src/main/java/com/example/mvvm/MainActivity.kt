package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

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

        viewModel.textViewStr.observe(this, Observer {
            binding.textView.text = it
        })
    }
}
package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
        // Fragment初期化
        val transition = supportFragmentManager.beginTransaction()
        transition.add(R.id.fragmentLayout, MainFragment())
        transition.commit()
        // ViewModel初期化
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.activityButton.setOnClickListener {
            viewModel.onClickActivityButton()
        }

        //  LiveDataを読み込み反映
        viewModel.cnt.observe(this, Observer {
            binding.activityTextView.text = it.toString()
        })
    }
}
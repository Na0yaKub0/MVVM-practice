package com.example.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOverlay
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // viewBinding初期化
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // 親のviewからViewModel初期化
        activity?.let {
            viewModel = ViewModelProvider(it)[MainViewModel::class.java]
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentButton.setOnClickListener {
            viewModel.onClickFragmentButton()
        }

        //  LiveDataを読み込み反映
        viewModel.cnt.observe(viewLifecycleOwner, Observer  {
            binding.fragmentTextView.text = it.toString()
        })

    }
}
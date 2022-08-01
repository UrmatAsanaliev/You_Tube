package com.example.ru_tube.ui.activity.main

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import com.example.ru_tube.R
import com.example.ru_tube.core.base.activity.BaseActivity
import com.example.ru_tube.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(ActivityMainBinding::inflate) {

    private lateinit var controller: NavHostController
    override val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun inflateViewBinding(lf: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(lf)
    }

    override fun setupUI() {
        initController()
    }

    private fun initController() {
//        controller = findNavController(R.id.nav_host_fragment) as NavHostController
    }

}
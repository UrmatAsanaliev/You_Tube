package com.example.ru_tube.core.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.ru_tube.R
import com.example.ru_tube.core.base.viewmodel.BaseViewModel

typealias Inflate<T> = (LayoutInflater) -> T

abstract class BaseActivity<VB : ViewBinding, VM: BaseViewModel>(
    private val inflate: Inflate<VB>): AppCompatActivity(){

    protected lateinit var binding: VB
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Ru_Tube)
        binding = inflate.invoke(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupObserve()
    }

    open fun setupObserve(){

    }

    abstract fun setupUI()


    abstract fun inflateViewBinding(lf: LayoutInflater): VB
}
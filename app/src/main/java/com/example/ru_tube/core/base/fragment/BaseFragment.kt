package com.example.ru_tube.core.base.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.ru_tube.core.base.viewmodel.BaseViewModel

typealias Inflate<VB> = (LayoutInflater, ViewGroup?, Boolean) -> VB

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(
    val inflate: Inflate<VB>
    ) :
    Fragment() {


    private var _binding: VB? = null
    private val binding get() = _binding!!
    protected abstract val viewModel: VM


    protected fun binding(): VB {
        return checkNotNull(binding)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
        if (checkInternetConnection(requireContext())) {
            showNoInternetScreen()
        }
    }

    private fun checkInternetConnection(context: Context): Boolean {
        val mgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = mgr.activeNetworkInfo
        return netInfo?.isConnected ?: false
    }

    abstract fun showNoInternetScreen()

    open fun setupObserver() {
    }

    abstract fun setupUI()


}
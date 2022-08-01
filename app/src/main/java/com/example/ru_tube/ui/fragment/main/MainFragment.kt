package com.example.ru_tube.ui.fragment.main

import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.ru_tube.core.base.fragment.BaseFragment
import com.example.ru_tube.databinding.FragmentMainBinding
import com.example.ru_tube.domain.Resource

class MainFragment : BaseFragment<FragmentMainBinding, PlayListViewModel>(
    FragmentMainBinding::inflate) {

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(requireActivity())[PlayListViewModel::class.java]
    }

    private lateinit var adapter : PlayListAdapter

    override fun showNoInternetScreen() {
        binding().progress.isVisible = true
    }

    override fun setupUI() {
        initPlayList()
        initAdapter()
    }

    private fun initPlayList() {
        viewModel.showSplash()
        viewModel.playList.observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING-> {
                    viewModel.progress.postValue(true)
                }
                Resource.Status.SUCCESS-> {
                    viewModel.progress.postValue(false)
                    viewModel.splash?.value = false
                    adapter.setList(it.data!!.items)
                    it.data.let{ it1 -> viewModel.setPlayList(it1)}
                }
                else -> {
                    viewModel.progress.postValue(false)
                    Log.e("ololo", "initView: ${it.message}")
                }
            }
        }
        viewModel.setPlayList.observe(viewLifecycleOwner){
        }
        viewModel.splash?.observe(viewLifecycleOwner){
            binding().splash.isVisible = it
        }
        viewModel.progress.observe(viewLifecycleOwner){
            binding().progress.isVisible = it
        }
    }

    private fun initAdapter(){
        adapter = PlayListAdapter(object : PlayListAdapter.IOnClick{
            override fun click(pos: Int) {

            }
        })
        binding().rvPlayList.adapter = adapter
    }
}
package com.example.ru_tube.ui.fragment.main

import android.util.Log
import androidx.core.view.isVisible
import com.example.ru_tube.core.base.fragment.BaseFragment
import com.example.ru_tube.databinding.FragmentMainBinding
import com.example.ru_tube.domain.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, PlayListViewModel>(
    FragmentMainBinding::inflate) {

    override val viewModel: PlayListViewModel by viewModel<PlayListViewModel>()

    private lateinit var adapter : PlayListAdapter

    override fun showNoInternetScreen() {
        binding().progress.isVisible = true
    }

    override fun setupUI() {
        initPlayList()
        initAdapter()
    }

    private fun initPlayList() {
        viewModel.playList.observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING-> {
                    viewModel.progress.postValue(true)
                }
                Resource.Status.SUCCESS-> {
                    viewModel.progress.postValue(false)
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
        viewModel.progress.observe(viewLifecycleOwner){
            binding().progress.isVisible = it
        }
    }

    private fun initAdapter(){
        adapter = PlayListAdapter()
        binding().rvPlayList.adapter = adapter
    }
}
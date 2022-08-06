package com.example.ru_tube.di

import com.example.ru_tube.ui.fragment.main.PlayListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PlayListViewModel(get()) }
}
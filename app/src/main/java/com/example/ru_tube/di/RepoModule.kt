package com.example.ru_tube.di

import com.example.ru_tube.data.repo.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModule: Module = module{
    single { Repository(get(), get()) }
}
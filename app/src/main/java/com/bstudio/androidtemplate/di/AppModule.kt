package com.bstudio.androidtemplate.di

import com.bstudio.androidtemplate.ui.home_screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
}
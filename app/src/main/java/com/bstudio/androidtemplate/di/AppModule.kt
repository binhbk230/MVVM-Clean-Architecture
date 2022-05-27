package com.bstudio.androidtemplate.di

import com.bstudio.androidtemplate.ui.home_screen.HomeViewModel
import com.bstudio.androidtemplate.ui.setting_screen.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SettingViewModel(get()) }
}
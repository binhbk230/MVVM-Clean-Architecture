package com.bstudio.androidtemplate.ui.setting_screen

import com.bstudio.androidtemplate.R
import com.bstudio.androidtemplate.base.BaseFragment
import com.bstudio.androidtemplate.databinding.HomeFragmentBinding
import com.bstudio.androidtemplate.databinding.SettingFragmentBinding
import org.koin.android.ext.android.inject

class SettingFragment: BaseFragment<SettingFragmentBinding>(R.layout.setting_fragment) {

    private val viewModel : SettingViewModel by inject()

    override fun doOnViewCreated() {

    }

    override fun initListener() {

    }

    override fun initObserver() {

    }


}
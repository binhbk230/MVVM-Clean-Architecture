package com.bstudio.androidtemplate.ui.setting_screen

import com.bstudio.androidtemplate.R
import com.bstudio.androidtemplate.base.BaseFragment
import com.bstudio.androidtemplate.databinding.SettingFragmentBinding
import com.bstudio.androidtemplate.util.collectLastestLifecycleFlow
import com.bstudio.androidtemplate.util.handleResponse
import org.koin.android.ext.android.inject

class SettingFragment: BaseFragment<SettingFragmentBinding>(R.layout.setting_fragment) {

    private val viewModel : SettingViewModel by inject()

    override fun doOnViewCreated() {
        viewModel.getAllNote()
    }

    override fun initListener() {

    }

    override fun initObserver() {
        collectLastestLifecycleFlow(viewModel.noteList) {
            it.handleResponse {
                val strBuilder = StringBuilder()
                it.data?.forEach {
                    strBuilder.append("${it.id}: ${it.title}\n")
                }
                viewBinding.tvNote.text = strBuilder.toString()
            }
        }
    }


}
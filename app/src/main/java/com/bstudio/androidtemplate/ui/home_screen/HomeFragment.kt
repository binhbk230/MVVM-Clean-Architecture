package com.bstudio.androidtemplate.ui.home_screen

import android.util.Log
import com.bstudio.androidtemplate.R
import com.bstudio.androidtemplate.base.BaseFragment
import com.bstudio.androidtemplate.common.Status
import com.bstudio.androidtemplate.databinding.HomeFragmentBinding
import com.bstudio.androidtemplate.util.collectLastestLifecycleFlow
import com.bumptech.glide.Glide
import org.koin.android.ext.android.inject

class HomeFragment: BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {

    private val viewModel : HomeViewModel by inject()

    override fun doOnViewCreated() {
        viewModel.getUserInfo("binhbk230")
    }

    override fun initListener() {

    }

    override fun initObserver() {
        collectLastestLifecycleFlow(viewModel.userInfo) {
            when(it.status) {
                Status.LOADING -> Log.e("binh", "Loading")
                Status.ERROR -> Log.e("binh", "error ${it.error.toString()}")
                else -> {
                    viewBinding.tvName.text = it.data?.name
                    viewBinding.tvCompany.text = it.data?.company
                    Glide.with(this).load(it.data?.avatarUrl).into(viewBinding.imgAvatar)
                }
            }
        }
    }


}
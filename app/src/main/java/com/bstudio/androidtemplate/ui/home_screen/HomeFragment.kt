package com.bstudio.androidtemplate.ui.home_screen

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.bstudio.androidtemplate.R
import com.bstudio.androidtemplate.base.BaseFragment
import com.bstudio.androidtemplate.common.Status
import com.bstudio.androidtemplate.databinding.HomeFragmentBinding
import com.bstudio.androidtemplate.util.collectLastestLifecycleFlow
import com.bstudio.androidtemplate.util.handleResponse
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class HomeFragment: BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {

    private val viewModel : HomeViewModel by inject()


    override fun doOnViewCreated() {
        lifecycleScope.launch {
            viewModel.userInfo.collectLatest {
                if (it.status != Status.SUCCESS)
                    viewModel.getUserInfo("binhbk230")
            }
        }
    }

    override fun initListener() {
        viewBinding.btnNext.setOnClickListener {
            router.navigate(R.id.action_homeFragment_to_settingFragment)
        }
    }

    override fun initObserver() {
        collectLastestLifecycleFlow(viewModel.userInfo) {
            it.handleResponse {
                viewBinding.tvName.text = it.data?.name
                viewBinding.tvCompany.text = it.data?.company
                Glide.with(this).load(it.data?.avatarUrl).into(viewBinding.imgAvatar)
            }
        }
    }


}
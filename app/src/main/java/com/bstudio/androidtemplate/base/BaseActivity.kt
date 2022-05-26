package com.bstudio.androidtemplate.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB: ViewDataBinding>(private val layoutId: Int): AppCompatActivity() {

    private lateinit var viewBinding : VB

    abstract fun initObserver()
    abstract fun doOnCreate()
    abstract fun initListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLayout()
        initListener()
        initObserver()
        doOnCreate()
    }

    private fun bindingLayout() {
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.lifecycleOwner = this
    }

}
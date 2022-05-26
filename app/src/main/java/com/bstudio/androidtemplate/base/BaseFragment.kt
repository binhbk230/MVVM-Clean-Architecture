package com.bstudio.androidtemplate.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<VB: ViewDataBinding>(private val layoutId: Int): Fragment() {

    protected lateinit var viewBinding : VB

    abstract fun doOnViewCreated()
    abstract fun initListener()
    abstract fun initObserver()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doOnViewCreated()
        initListener()
        initObserver()
    }

    protected fun navigate(destination: Int) {
        findNavController().navigate(destination)
    }
}
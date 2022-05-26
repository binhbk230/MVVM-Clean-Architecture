package com.bstudio.androidtemplate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.bstudio.androidtemplate.R
import com.bstudio.androidtemplate.common.Status
import com.bstudio.androidtemplate.util.collectLastestLifecycleFlow
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.getUserInfo("binhbk230")

        collectLastestLifecycleFlow(viewModel.userInfo) {
            when(it.status) {
                Status.LOADING -> Log.e("binh", "Loading")
                Status.ERROR -> Log.e("binh", "error ${it.error.toString()}")
                else -> {
                    findViewById<TextView>(R.id.tvName).text = it.data?.name
                    findViewById<TextView>(R.id.tvCompany).text = it.data?.company
                    Glide.with(this).load(it.data?.avatarUrl).into(findViewById(R.id.imgAvatar))
                }
            }
        }

    }
}
package com.bstudio.androidtemplate.base

import androidx.navigation.NavController

open class BaseRouter(private val navController: NavController) {
    fun navigate(destination: Int) {
        navController.navigate(destination)
    }
}
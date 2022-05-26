package com.bstudio.androidtemplate.ui.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bstudio.androidtemplate.common.Response
import com.bstudio.data.response.UserInfoResponse
import com.bstudio.domain.usecase.userinfo.UserInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: UserInfoUseCase): ViewModel() {

    private val _userInfo = MutableStateFlow<Response<UserInfoResponse>>(Response.loading())
    val userInfo = _userInfo.asStateFlow()


    fun getUserInfo(user: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getUserInfo(user)
                .onStart {
                    _userInfo.value = Response.loading()
                }.catch {
                    _userInfo.value = Response.error(it)
                }.collect {
                    _userInfo.value = Response.success(it)
                }
        }
    }
}
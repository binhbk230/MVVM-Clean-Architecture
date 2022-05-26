package com.bstudio.androidtemplate.ui.setting_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bstudio.androidtemplate.common.Response
import com.bstudio.data.response.UserInfoResponse
import com.bstudio.domain.usecase.userinfo.UserInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SettingViewModel(private val useCase: UserInfoUseCase): ViewModel() {


}
package com.bstudio.domain.usecase.userinfo

import com.bstudio.data.response.UserInfoResponse
import kotlinx.coroutines.flow.Flow

interface UserInfoUseCase {
    fun getUserInfo(userId: String): Flow<UserInfoResponse>
}
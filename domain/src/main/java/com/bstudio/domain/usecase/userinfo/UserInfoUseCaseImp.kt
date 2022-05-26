package com.bstudio.domain.usecase.userinfo

import com.bstudio.data.repository.GithubRepository
import com.bstudio.data.response.UserInfoResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserInfoUseCaseImp(private val service: GithubRepository): UserInfoUseCase {
    override fun getUserInfo(userId: String): Flow<UserInfoResponse> {
        return flow {
            emit(service.getUserInfo(userId))
        }
    }
}
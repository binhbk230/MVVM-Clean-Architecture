package com.bstudio.data.service

import com.bstudio.data.response.UserInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}")
    suspend fun getUserInfo(@Path(value = "user", encoded = true) user: String): UserInfoResponse
}
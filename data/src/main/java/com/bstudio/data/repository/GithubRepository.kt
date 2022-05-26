package com.bstudio.data.repository

import com.bstudio.data.service.GitHubService

class GithubRepository(private val gitHubService: GitHubService) {
    suspend fun getUserInfo(user: String) = gitHubService.getUserInfo(user)
}
package com.bstudio.di

import com.bstudio.data.repository.GithubRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { GithubRepository(get()) }
}
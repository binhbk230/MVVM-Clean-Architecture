package com.bstudio.di

import com.bstudio.data.repository.GithubRepository
import com.bstudio.data.repository.NoteDBRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { GithubRepository(get()) }
    single { NoteDBRepository(get()) }
}
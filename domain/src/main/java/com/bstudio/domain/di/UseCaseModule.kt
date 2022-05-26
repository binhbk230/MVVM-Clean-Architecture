package com.bstudio.domain.di

import com.bstudio.domain.usecase.userinfo.UserInfoUseCase
import com.bstudio.domain.usecase.userinfo.UserInfoUseCaseImp
import org.koin.dsl.module

val useCaseModule = module {
    factory<UserInfoUseCase> { UserInfoUseCaseImp(get()) }
}
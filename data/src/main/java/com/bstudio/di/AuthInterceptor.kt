package com.bstudio.di

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    
    companion object {
        private var token = "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"
        fun setToken(mToken : String) {
            token = mToken
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "$token")
            .build()
        return chain.proceed(newRequest)
    }
}

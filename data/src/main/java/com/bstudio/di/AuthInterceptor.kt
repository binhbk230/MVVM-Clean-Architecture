package com.bstudio.di

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        // DONT INCLUDE API KEYS IN YOUR SOURCE CODE
        //val url = req.url.newBuilder().addQueryParameter("Authorization", "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").build()
        //req = req.newBuilder().url(url).build()
        req.headers.newBuilder().add("Authorization", "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")

        return chain.proceed(req)
    }
}
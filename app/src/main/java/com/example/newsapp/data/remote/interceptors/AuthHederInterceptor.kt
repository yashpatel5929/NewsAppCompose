package com.example.newsapp.data.remote.interceptors

import com.example.newsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("api_token" , BuildConfig.ACCESS_TOKEN)
        return chain.proceed(request.build())
    }
}
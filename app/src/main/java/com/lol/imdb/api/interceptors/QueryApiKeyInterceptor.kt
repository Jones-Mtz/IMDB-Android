package com.lol.imdb.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class QueryApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url().newBuilder()
            .addQueryParameter("apiKey", "5C0F2872").build()
        val requestWithApiKey = originalRequest.newBuilder().url(url).build()
        return chain.proceed(requestWithApiKey)
    }
}

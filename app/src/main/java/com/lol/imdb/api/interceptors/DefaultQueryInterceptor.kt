package com.lol.imdb.api.interceptors

import com.lol.imdb.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class DefaultQueryInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url().newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .addQueryParameter("include_adult", "false")
            .addQueryParameter("language", "es-MX").build()
        val requestWithApiKey = originalRequest.newBuilder().url(url).build()
        return chain.proceed(requestWithApiKey)
    }
}

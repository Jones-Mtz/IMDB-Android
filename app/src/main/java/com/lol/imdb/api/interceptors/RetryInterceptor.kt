package com.lol.imdb.api.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RetryInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        var response: Response = chain.proceed(request)
        var tryCount = 0

        while (!response.isSuccessful && tryCount < 5) {
            tryCount++
            response = chain.proceed(request)
        }

        return response
    }
}

package com.lol.imdb.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Jones on 05/01/19.
 */
class RetrofitProvider @Inject constructor(private val gson: Gson, private val okHttpClient: OkHttpClient,
                                           private val baseUrl: String) : Provider<Retrofit> {
    override fun get(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }
}
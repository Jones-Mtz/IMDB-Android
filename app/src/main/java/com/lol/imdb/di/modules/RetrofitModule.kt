package com.lol.imdb.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lol.imdb.BuildConfig
import com.lol.imdb.api.RetrofitProvider
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Jones on 03/01/19.
 */
@Module
class RetrofitModule {

    @Named("BaseURL")
    @Provides
    @Singleton
    fun provideURL(): String {
        return "http://www.lol.com.mx"
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .create()
    }

    @Named("log")
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            )
    }

    /*@Named("retry")
    @Provides
    @Singleton
    fun provideRetryInterceptor(): Interceptor {
        return Interceptor {
            val request: Request = it.request()
            var response: Response = it.proceed(request)
            var tryCount = 0

            while (!response.isSuccessful && tryCount < 5) {
                tryCount++
                response = it.proceed(request)
            }

            return@Interceptor response
        }
    }*/


    /*@Named("apikey")
    @Provides
    @Singleton
    fun provideApiKeyDefaultInterceptor(): Interceptor {
        return Interceptor {
            val originalRequest = it.request()
            val url = originalRequest.url().newBuilder()
                .addQueryParameter("apikey", "5C0F2872").build()
            val requestWithApiKey = originalRequest.newBuilder().url(url).build()
            it.proceed(requestWithApiKey)
        }
    }*/


    @Provides
    @Singleton
    fun provideDispatcher(): Dispatcher {
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 8
        return dispatcher
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(@Named("log")loggingInterceptor: HttpLoggingInterceptor,
//                            @Named("retry")retryInterceptor: HttpLoggingInterceptor,
//                            @Named("apikey")apikeyInterceptor: HttpLoggingInterceptor,
        dispatcher: Dispatcher
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
//            .addInterceptor(retryInterceptor)
//            .addInterceptor(apikeyInterceptor)
            .dispatcher(dispatcher)
            .build()
    }

    @Provides
//    @Named("baseRetrofit")
    @Singleton
    fun provideBaseRetrofit(gson: Gson, okHttpClient: OkHttpClient, @Named("BaseURL") baseUrl: String): Retrofit {
        return RetrofitProvider(gson, okHttpClient, baseUrl).get()
    }

    /*@Provides
    @Singleton
    fun provideRetrofitFactory(gson: Gson, okHttpClient: OkHttpClient,
                               @Named("BaseURL") baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }*/

}
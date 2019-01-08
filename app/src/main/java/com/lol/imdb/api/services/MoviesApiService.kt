package com.lol.imdb.api.services

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jones on 05/01/19.
 */
interface MoviesApiService {

    @GET(".")
    fun simpleTitleSearch(@Query("t") title: String): Single<String>

}
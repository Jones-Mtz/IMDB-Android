package com.lol.imdb.api.services

import com.lol.imdb.api.responses.MoviesResponse
import com.lol.imdb.api.responses.models.MovieSummary
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jones on 05/01/19.
 */
interface MoviesApiService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int?): Single<MoviesResponse>

    @GET(".")
    fun simpleSearch(@Query("query") title: String, @Query("page") page: Int): Single<MovieSummary>

}
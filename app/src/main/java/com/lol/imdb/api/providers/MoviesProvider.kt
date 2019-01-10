package com.lol.imdb.api.providers

import com.lol.imdb.api.responses.MoviesResponse
import com.lol.imdb.api.responses.models.MovieSummary
import io.reactivex.Single

/**
 * Created by Jones on 05/01/19.
 */
interface MoviesProvider {

    fun getPopularMovies(page: Int = 1): Single<MoviesResponse>

    fun simpleTitleSearch(title: String, page: Int = 1): Single<MovieSummary>

}
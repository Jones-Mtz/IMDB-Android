package com.lol.imdb.api.providers

import com.lol.imdb.api.responses.PopularMoviesResponse
import com.lol.imdb.api.responses.models.MovieSummary
import io.reactivex.Single

/**
 * Created by Jones on 05/01/19.
 */
interface MoviesProvider {

    fun getPopularMovies(page: Int): Single<PopularMoviesResponse>

    fun simpleTitleSearch(title: String, page: Int = 1): Single<MovieSummary>


}
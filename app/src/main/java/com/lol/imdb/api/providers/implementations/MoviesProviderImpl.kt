package com.lol.imdb.api.providers.implementations

import com.lol.imdb.api.providers.MoviesProvider
import com.lol.imdb.api.responses.MoviesResponse
import com.lol.imdb.api.responses.models.MovieSummary
import com.lol.imdb.api.services.MoviesApiService
import io.reactivex.Single

class MoviesProviderImpl(private val moviesApiService: MoviesApiService) : MoviesProvider {

    override fun getPopularMovies(page: Int): Single<MoviesResponse> {
        return moviesApiService.getPopularMovies(page)
    }


    override fun simpleTitleSearch(title: String, page: Int): Single<MovieSummary> {
        return moviesApiService.simpleSearch(title, page)
    }

}
package com.lol.imdb.api.providers.implementations

import com.lol.imdb.api.providers.MoviesProvider
import com.lol.imdb.api.services.MoviesApiService
import io.reactivex.Single

class MoviesProviderImpl(private val moviesApiService: MoviesApiService) : MoviesProvider{

    override fun simpleTitleSearch(title: String): Single<String> {
        return moviesApiService.simpleTitleSearch(title)
    }

}
package com.lol.imdb.api.responses

import com.lol.imdb.api.responses.models.MovieSummary

/**
 * Created by Jones on 09/01/19.
 */
class MoviesResponse {
    var totalResults: String? = null
    var totalPages: String? = null
    var results: List<MovieSummary>? = listOf()
}
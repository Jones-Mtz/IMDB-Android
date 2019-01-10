package com.lol.imdb.ui.feed

import com.lol.imdb.api.responses.models.MovieSummary

/**
 * Created by Jones on 09/01/19.
 */
data class MovieFeedPresentationModel(
    val movies: List<MovieSummary> = arrayListOf()
)
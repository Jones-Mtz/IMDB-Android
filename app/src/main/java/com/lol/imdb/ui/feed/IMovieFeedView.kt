package com.lol.imdb.ui.feed

import com.lol.imdb.api.responses.models.MovieSummary
import com.lol.imdb.ui.base.IBaseView

/**
 * Created by Jones on 09/01/19.
 */
interface IMovieFeedView : IBaseView {

    fun setUpRecycler()
    fun populateList(movies: List<MovieSummary>)

}
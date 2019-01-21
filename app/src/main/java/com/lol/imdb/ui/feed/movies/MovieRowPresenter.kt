package com.lol.imdb.ui.feed.movies


import com.lol.imdb.api.responses.models.MovieSummary
import com.lol.imdb.ui.base.rows.IBaseItemRowPresenter

/**
 * Created by Jones on 17/01/19.
 */
class MovieRowPresenter<IView : IMovieRowView> : IBaseItemRowPresenter<IView> {

    var movies: List<MovieSummary> = listOf()

    override fun onBindRowViewAtPosition(iView: IView, position: Int) {
        iView.setTitle(movies[position].title ?: "")
        iView.setRate(movies[position].overview ?: "")
    }


    override fun getRowsCount(): Int {
        return movies.size
    }
}
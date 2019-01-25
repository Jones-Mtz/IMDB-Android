package com.lol.imdb.ui.feed.movies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.lol.imdb.R
import com.lol.imdb.api.responses.models.MovieSummary
import com.lol.imdb.ui.feed.MovieFeedFragment

/**
 * Created by Jones on 10/01/19.
 */
class MovieFeedAdapter(
    private val presenter: MovieRowPresenter<IMovieRowView>,
    private val iMovieItemClicked: MovieFeedFragment.IMovieItemClicked
) :
    RecyclerView.Adapter<MovieViewHolder>() {

    fun setMovies(movies: List<MovieSummary>) {
        presenter.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            iMovieItemClicked,
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_summary, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return presenter.getRowsCount()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        presenter.onBindRowViewAtPosition(holder, position)
    }
}
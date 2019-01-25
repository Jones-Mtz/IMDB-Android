package com.lol.imdb.ui.feed.movies

import android.support.v7.widget.RecyclerView
import android.view.View
import com.lol.imdb.ui.feed.MovieFeedFragment
import kotlinx.android.synthetic.main.item_movie_summary.view.*

/**
 * Created by Jones on 17/01/19.
 */
class MovieViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), IMovieRowView {
    private var iMovieItemClicked: MovieFeedFragment.IMovieItemClicked? = null


    constructor(
        iMovieItemClicked: MovieFeedFragment.IMovieItemClicked,
        itemView: View?
    ) : this(itemView) {

        this.iMovieItemClicked = iMovieItemClicked
        itemView?.setOnClickListener { iMovieItemClicked.itemClicked(adapterPosition) }
    }

    override fun setImage(url: String) {
//        todo: use picasso or something like that

    }

    override fun setTitle(title: String) {
        itemView.tvItemMovieTitle.text = title
    }

    override fun setRate(rate: String) {
        itemView.tvItemMovieOverview.text = rate
    }
}
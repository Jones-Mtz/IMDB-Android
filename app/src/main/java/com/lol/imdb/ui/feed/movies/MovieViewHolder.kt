package com.lol.imdb.ui.feed.movies

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_movie_summary.view.*

/**
 * Created by Jones on 17/01/19.
 */
class MovieViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), IMovieRowView {
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
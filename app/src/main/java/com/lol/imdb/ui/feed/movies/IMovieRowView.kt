package com.lol.imdb.ui.feed.movies

import com.lol.imdb.ui.base.rows.IBaseRowView

/**
 * Created by Jones on 17/01/19.
 */
interface IMovieRowView : IBaseRowView {
    fun setImage(url: String)
    fun setTitle(title: String)
    fun setRate(rate: String)
}
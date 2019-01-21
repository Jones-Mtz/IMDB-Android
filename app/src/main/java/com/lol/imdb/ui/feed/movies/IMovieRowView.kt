package com.lol.imdb.ui.feed.movies

/**
 * Created by Jones on 17/01/19.
 */
interface IMovieRowView /*: IBaseRowView*/ {
    fun setImage(url: String)
    fun setTitle(title: String)
    fun setRate(rate: String)
}
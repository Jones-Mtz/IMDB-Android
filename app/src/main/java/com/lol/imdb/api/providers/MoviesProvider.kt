package com.lol.imdb.api.providers

import io.reactivex.Single

/**
 * Created by Jones on 05/01/19.
 */
interface MoviesProvider {

    fun simpleTitleSearch(title: String): Single<String>

}
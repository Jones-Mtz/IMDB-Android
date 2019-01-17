package com.lol.imdb.di.modules

import com.lol.imdb.ui.feed.IMovieFeedPresenter
import com.lol.imdb.ui.feed.IMovieFeedView
import com.lol.imdb.ui.feed.MovieFeedPresenter
import com.lol.imdb.ui.feed.movies.MovieFeedAdapter
import com.lol.imdb.ui.feed.movies.MovieRowPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by Jones on 10/01/19.
 */
@Module
class MovieFeedModule {

    @Named("lol")
    @Provides
    fun provideLOL(): String = "Finally you got it!!"

    @Provides
    fun provideMovieFeedPresenter(presenter: MovieFeedPresenter<IMovieFeedView>): IMovieFeedPresenter<IMovieFeedView> =
        presenter

    @Provides
    fun provideMovieFeedAdapter(movieRowPresenter: MovieRowPresenter) = MovieFeedAdapter(movieRowPresenter)

    @Provides
    fun provideMovieRowPresenter() = MovieRowPresenter()
}
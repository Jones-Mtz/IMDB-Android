package com.lol.imdb.di

import com.lol.imdb.di.modules.MovieFeedModule
import com.lol.imdb.di.modules.MoviesModule
import com.lol.imdb.ui.base.BaseFragment
import com.lol.imdb.ui.feed.MovieFeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Jones on 10/01/19.
 */
@Module
abstract class FragmentBuilder {

    @PerFragment
    @ContributesAndroidInjector()
    abstract fun bindBaseFragment(): BaseFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [MovieFeedModule::class, MoviesModule::class])
    abstract fun bindMovieFeedFragment(): MovieFeedFragment


}
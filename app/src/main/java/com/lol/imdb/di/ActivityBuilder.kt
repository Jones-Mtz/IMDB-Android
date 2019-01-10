package com.lol.imdb.di

import com.lol.imdb.di.modules.MainActivityModule
import com.lol.imdb.di.modules.MoviesModule
import com.lol.imdb.ui.base.BaseActivity
import com.lol.imdb.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Jones on 03/01/19.
 */
@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector()
    abstract fun bindBaseActivity(): BaseActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (MoviesModule::class), (FragmentBuilder::class)])
    abstract fun bindMainActivity(): MainActivity


}
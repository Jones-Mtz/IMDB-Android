package com.lol.imdb.di.modules

import com.lol.imdb.ui.main.IMainPresenter
import com.lol.imdb.ui.main.IMainView
import com.lol.imdb.ui.main.MainPresenter
import dagger.Module
import dagger.Provides


/**
 * Created by Jones on 03/01/19.
 */
@Module
class MainActivityModule {

    @Provides
    fun provideMainPresenter(presenter: MainPresenter<IMainView>): IMainPresenter<IMainView> {
        return presenter
    }

    @Provides
    fun provideLOL(): String = "Finally you got it!!"

//    Cause there's only one retrofit module and it will be used on all app is separated
    /*@Provides
    fun provideMoviesRetrofit(retrofit: Retrofit): Retrofit {
        return retrofit
    }*/

}
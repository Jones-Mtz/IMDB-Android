package com.lol.imdb.di.components

import android.app.Application
import com.lol.imdb.IMDB
import com.lol.imdb.di.ActivityBuilder
import com.lol.imdb.di.modules.AppModule
import com.lol.imdb.di.modules.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Jones on 04/01/19.
 */
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class), (RetrofitModule::class)])
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: IMDB)
}
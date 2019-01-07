package com.lol.imdb.di.modules

import com.lol.imdb.api.providers.MoviesProvider
import com.lol.imdb.api.providers.implementations.MoviesProviderImpl
import com.lol.imdb.api.services.MoviesApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class MoviesModule {

    @Provides
    fun provideMoviesApiService(@Named("baseRetrofit") retrofit: Retrofit): MoviesApiService {
        return retrofit.create(MoviesApiService::class.java)
    }

    @Provides
    fun provideMoviesMoviesProvider(moviesApiService: MoviesApiService): MoviesProvider {
        return MoviesProviderImpl(moviesApiService)
    }


}
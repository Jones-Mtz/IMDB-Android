package com.lol.imdb.ui.feed

import com.lol.imdb.api.providers.MoviesProvider
import com.lol.imdb.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Jones on 09/01/19.
 */
class MovieFeedPresenter<IView : IMovieFeedView>
@Inject constructor() : BasePresenter<IView>(), IMovieFeedPresenter<IView> {

    @Inject
    lateinit var moviesProvider: MoviesProvider

    override fun onAttach(view: IView) {
        super.onAttach(view)
        iView?.setUpRecycler()
    }

    override fun getPopularMovies() {
        moviesProvider.getPopularMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                iView?.showLoader()
            }
            .doFinally {
                iView?.hideLoader()
            }
            .subscribe(
                { response ->
                    response.results
                    iView?.populateList(response.results ?: listOf())
                },
                { OnError ->
                    iView?.showToast("Something went wrong x_x")
                })
    }
}
package com.lol.imdb.ui.main

import com.lol.imdb.api.providers.MoviesProvider
import com.lol.imdb.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Jones on 03/01/19.
 */

class MainPresenter<IView : IMainView>
@Inject constructor() : BasePresenter<IView>(), IMainPresenter<IView> {

    @Inject
    lateinit var moviesProvider: MoviesProvider

    override fun setUpMainFragment() {
        iView?.buildFragments()
        iView?.goToMainFragment()
    }

    override fun getPopularMovies(message: String) {
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
                            iView?.showToast(message)
                        },
                        { OnError ->
                            iView?.showToast("Something went wrong x_x")
                        })
    }

    /*Single.merge(
        moviesProvider.simpleSearch(("terminator")),
        moviesProvider.simpleSearch(("lkjass23")),
        moviesProvider.simpleSearch(("coraline"))
    )
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { a ->
                iView?.showToast("You did it!!")
            },
            { OnError ->
                iView?.showToast("Something went wrong x_x")
            }
        )
}*/
}
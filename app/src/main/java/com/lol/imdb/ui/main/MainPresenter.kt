package com.lol.imdb.ui.main

import com.lol.imdb.api.providers.MoviesProvider
import com.lol.imdb.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Jones on 03/01/19.
 */
//@PerActivity
class MainPresenter<IView : IMainView>
@Inject constructor(/*retrofit: Retrofit*/) : BasePresenter<IView>(/*retrofit*/), IMainPresenter<IView> {

    @Inject
    lateinit var moviesProvider: MoviesProvider

    override fun onButtonClick(message: String) {
//        iView?.showToast(message)
        val disposable =
            moviesProvider.getPopularMovies(1)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    //                todo: show loader
                }
                .doFinally {
                    //                todo: hide loader
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
        .doOnSubscribe {
            //                todo: show loader
        }
        .doFinally {
            //                todo: hide loader
        }
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
package com.lol.imdb.ui.main

import com.lol.imdb.api.providers.MoviesProvider
import com.lol.imdb.ui.base.BasePresenter
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins.onError
import io.reactivex.schedulers.Schedulers
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
        val disposable = moviesProvider.simpleTitleSearch("terminator")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                //                todo: show loader
            }
            .doFinally {
                //                todo: hide loader
            }.subscribe(
                { t1 ->
                    iView?.showToast("You did it!!")
                },
                { OnError ->
                    iView?.showToast("Something went wrong x_x")
                })
    }
}
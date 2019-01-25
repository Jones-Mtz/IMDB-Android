package com.lol.imdb.ui.base

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Jones on 03/01/19.
 */
open class BasePresenter<IView : IBaseView> @Inject constructor() : IBasePresenter<IView> {
    val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    var iView: IView? = null

    override fun onAttach(view: IView) {
        this.iView = view
    }

    override fun onDetach() {
        iView = null
        compositeDisposable.clear()
    }

    override fun isViewAttached(): Boolean {
        return iView !== null
    }
}
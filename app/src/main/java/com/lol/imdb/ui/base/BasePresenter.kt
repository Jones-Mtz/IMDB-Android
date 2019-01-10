package com.lol.imdb.ui.base

import com.lol.imdb.di.PerActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Jones on 03/01/19.
 */
@PerActivity
open class BasePresenter<IView : IBaseView> @Inject constructor() : IBasePresenter<IView> {
    var disposable: Disposable? = null

    var iView: IView? = null

    override fun onAttach(view: IView) {
        this.iView = view
    }

    override fun onDetach() {
        iView = null
        disposable?.dispose()
    }

    override fun isViewAttached(): Boolean {
        return iView !== null
    }
}
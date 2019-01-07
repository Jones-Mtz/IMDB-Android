package com.lol.imdb.ui.base

import com.lol.imdb.di.PerActivity
import javax.inject.Inject

/**
 * Created by Jones on 03/01/19.
 */
@PerActivity
open class BasePresenter<IView : IBaseView> @Inject constructor(/*var retrofit: Retrofit*/) : IBasePresenter<IView> {

    var iView: IBaseView? = null

//    @Inject
//    lateinit var retrofit: Retrofit


    override fun onAttach(view: IView) {
        this.iView = view
    }

    override fun onDetach() {
        iView = null
    }

    override fun isViewAttached(): Boolean {
        return iView !== null
    }
}
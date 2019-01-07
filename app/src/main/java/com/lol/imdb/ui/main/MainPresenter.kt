package com.lol.imdb.ui.main

import com.lol.imdb.ui.base.BasePresenter
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Jones on 03/01/19.
 */
//@PerActivity
class MainPresenter<IView : IMainView>
@Inject constructor(/*retrofit: Retrofit*/) : BasePresenter<IView>(/*retrofit*/), IMainPresenter<IView> {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onButtonClick(message: String) {
        iView?.showToast(message)
        retrofit.baseUrl()
    }

}
package com.lol.imdb.ui.main

import com.lol.imdb.ui.base.IBasePresenter

/**
 * Created by Jones on 03/01/19.
 */
interface IMainPresenter<IView: IMainView>: IBasePresenter<IView> {

    fun onButtonClick(message: String)

}
package com.lol.imdb.ui.base

/**
 * Created by Jones on 03/01/19.
 */
interface IBasePresenter<IView : IBaseView> {

    fun onAttach(view: IView)

    fun onDetach()

    fun isViewAttached(): Boolean

}
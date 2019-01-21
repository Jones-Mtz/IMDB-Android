package com.lol.imdb.ui.details

import com.lol.imdb.ui.base.IBasePresenter
import com.lol.imdb.ui.base.IBaseView

/**
 * Created by Jones on 19/01/19.
 */
interface MovieDetailsContract {
    interface IMovieDetailsPresenter<IView : IBaseView> : IBasePresenter<IView> {}

    interface IMovieDetailsView : IBaseView {}
}
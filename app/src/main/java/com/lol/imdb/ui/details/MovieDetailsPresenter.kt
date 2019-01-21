package com.lol.imdb.ui.details

import com.lol.imdb.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by Jones on 19/01/19.
 */
class MovieDetailsPresenter<IView : MovieDetailsContract.IMovieDetailsView>
@Inject constructor() : BasePresenter<IView>(), MovieDetailsContract.IMovieDetailsPresenter<IView> {
}
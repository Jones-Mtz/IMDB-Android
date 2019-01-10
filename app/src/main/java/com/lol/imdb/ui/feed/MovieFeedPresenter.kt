package com.lol.imdb.ui.feed

import com.lol.imdb.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by Jones on 09/01/19.
 */
class MovieFeedPresenter<IView : IMovieFeedView>
@Inject constructor() : BasePresenter<IView>(), IMovieFeedPresenter<IView> {
}
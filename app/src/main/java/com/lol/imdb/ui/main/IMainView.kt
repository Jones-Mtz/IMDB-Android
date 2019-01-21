package com.lol.imdb.ui.main

import com.lol.imdb.ui.base.IBaseView

/**
 * Created by Jones on 03/01/19.
 */
interface IMainView : IBaseView {
    fun buildFragments()
    fun goToMainFragment()
    fun setUpButtonNav()
    fun starFullReviewActivity()
}
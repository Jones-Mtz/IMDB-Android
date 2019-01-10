package com.lol.imdb.ui.base

import android.support.v4.app.Fragment

/**
 * Created by Jones on 03/01/19.
 */
interface IBaseView {

    fun showToast(message: String)

    fun showLoader()

    fun hideLoader()

    interface IBaseActivity {
        //    –Add parameters with default values if you need, likeAnimations
        fun goFragment(fragment: Fragment?, idContainer: Int)
    }

    interface IBaseFragment {
    }
}
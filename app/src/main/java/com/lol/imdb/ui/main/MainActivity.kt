package com.lol.imdb.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MotionEvent
import com.lol.imdb.R
import com.lol.imdb.ui.base.BaseActivity
import com.lol.imdb.ui.feed.MovieFeedFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


/**
 * Created by Jones on 03/01/19.
 */
class MainActivity : BaseActivity(), HasSupportFragmentInjector, IMainView {

    private var currentFragment: MovieFeedFragment? = null

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    internal lateinit var presenter: IMainPresenter<IMainView>

    @Inject
    lateinit var message: String

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        with(presenter) {
            onAttach(this@MainActivity)
            setUpMainFragment()
//            getPopularMovies(message)
        }
    }

    override fun buildFragments() {
        currentFragment = MovieFeedFragment.newInstance(0)
    }

    override fun goToMainFragment() {
        goFragment(currentFragment, R.id.flMainContainer)
    }

    override fun setUpButtonNav() {
        bnMainBar.selectedItemId = R.id.action_popular

        bnMainBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_popular -> {
                }
                R.id.action_favourites -> {
                }
                R.id.action_search -> {
                }

            }
            false
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

}

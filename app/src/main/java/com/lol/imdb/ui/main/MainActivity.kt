package com.lol.imdb.ui.main

import android.os.Bundle
import android.view.MotionEvent
import com.lol.imdb.R
import com.lol.imdb.ui.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by Jones on 03/01/19.
 */
class MainActivity : BaseActivity(), IMainView {

    @Inject
    internal lateinit var presenter: IMainPresenter<IMainView>

    @Inject
    lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
//        presenter.onAttach(this)

//         use with if you need many methods with the presenter or some class
        with(presenter) {
            onAttach(this@MainActivity)
        }

        btn_main.setOnClickListener {
            presenter.onButtonClick(message)
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

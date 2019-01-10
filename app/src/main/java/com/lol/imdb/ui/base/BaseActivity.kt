package com.lol.imdb.ui.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.widget.Toast
import com.lol.imdb.R
import dagger.android.AndroidInjection

/**
 * Created by Jones on 03/01/19.
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView, IBaseView.IBaseActivity {
    private var loader: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoader() {
        if (loader == null) {
            createLoader()
        }
        loader?.show()
    }

    override fun hideLoader() {
        loader?.hide()
    }

    override fun goFragment(fragment: Fragment?, idContainer: Int) {
        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            ft.setCustomAnimations(
                android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out
            )
            ft.replace(idContainer, fragment)
            ft.commit()
        }
    }

    private fun createLoader() {
        loader = Dialog(this)
        loader?.setCancelable(false)
        loader?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loader?.setContentView(R.layout.dialog_loading)
        loader?.window?.addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        loader?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

}
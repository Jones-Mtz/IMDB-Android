package com.lol.imdb.ui.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v4.app.Fragment
import android.view.Window
import android.widget.Toast
import com.lol.imdb.R

/**
 * Created by Jones on 09/01/19.
 */
abstract class BaseFragment : Fragment(), IBaseView, IBaseView.IBaseFragment {
    private var loader: Dialog? = null


    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
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

    private fun createLoader() {
        loader = Dialog(context)
        loader?.setCancelable(false)
        loader?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loader?.setContentView(R.layout.dialog_loading)
        loader?.window?.addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        loader?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}
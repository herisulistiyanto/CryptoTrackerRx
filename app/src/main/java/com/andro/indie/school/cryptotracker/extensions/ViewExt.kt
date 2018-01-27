package com.andro.indie.school.cryptotracker.extensions

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View
import android.view.Window
import android.view.WindowManager

/**
 * Created by herisulistiyanto on 9/7/17.
 */

inline fun View.showSnackbar(snackbarText: String,
                             timeLength: Int = Snackbar.LENGTH_LONG,
                             listener: Snackbar.() -> Unit = {}) =
        Snackbar.make(this, snackbarText, timeLength).apply {
            listener()
            show()
        }


inline fun View.showSnackbar(@StringRes snackbarTextRes: Int,
                             timeLength: Int = Snackbar.LENGTH_LONG,
                             listener: Snackbar.() -> Unit = {}) =
        Snackbar.make(this, snackbarTextRes, timeLength).apply {
            listener()
            show()
        }

fun Window.blockTouchScreen() {
    this.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}

fun Window.unblockTouchScreen() {
    this.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}
package com.andro.indie.school.cryptotracker.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.content.res.AppCompatResources
import android.util.TypedValue

/**
 * Created by herisulistiyanto on 9/7/17.
 */

@Suppress("DEPRECATION")
fun Context.getColorCompat(@ColorRes colorId: Int) =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ContextCompat.getColor(this, colorId)
        } else this.resources.getColor(colorId)

fun Context.getDrawableCompat(@DrawableRes drawableId: Int) =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.resources.getDrawable(drawableId, null)
        } else AppCompatResources.getDrawable(this, drawableId)

fun Context.getConnectivityManager(): ConnectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

fun Context.convertDpToPx(dp: Int): Int {
    return Math.round(TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), this.resources.displayMetrics))
}
package com.andro.indie.school.cryptotracker.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by herisulistiyanto on 9/7/17.
 */
inline fun <reified T : Any> clazz() = T::class.java

inline fun <reified T : Any> tag() = T::class.java.simpleName

fun String.safeToLong(): Long {
    return this.toLongOrNull() ?: 0L
}

fun Long.unixToDate(pattern: String = "dd MMM YYYY, HH:mm:ss"): String {
    val date = Date(this * 1000L)
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    return sdf.format(date)
}

fun String.trimTrailingZeros(): String? {
    return if (!this.contains(".")) {
        this
    } else {
        this.replace("\\.?0*$".toRegex(), "")
    }
}

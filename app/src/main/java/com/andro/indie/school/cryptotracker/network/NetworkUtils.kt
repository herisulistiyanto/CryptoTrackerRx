package com.andro.indie.school.cryptotracker.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.telephony.TelephonyManager
import com.andro.indie.school.cryptotracker.extensions.getConnectivityManager

/**
 * Created by herisulistiyanto on 8/30/17.
 */

class NetworkUtils(private val context: Context) {

    private val connectivityStatus: Int
        get() {
            val cm = context.getConnectivityManager()
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            activeNetwork?.let {
                return when (it.type) {
                    ConnectivityManager.TYPE_WIFI -> TYPE_WIFI
                    ConnectivityManager.TYPE_MOBILE -> when (it.subtype) {
                        TelephonyManager.NETWORK_TYPE_GPRS,
                        TelephonyManager.NETWORK_TYPE_EDGE,
                        TelephonyManager.NETWORK_TYPE_CDMA,
                        TelephonyManager.NETWORK_TYPE_1xRTT,
                        TelephonyManager.NETWORK_TYPE_IDEN -> TYPE_MOBILE_2G

                        TelephonyManager.NETWORK_TYPE_UMTS,
                        TelephonyManager.NETWORK_TYPE_EVDO_0,
                        TelephonyManager.NETWORK_TYPE_EVDO_A,
                        TelephonyManager.NETWORK_TYPE_HSDPA,
                        TelephonyManager.NETWORK_TYPE_HSUPA,
                        TelephonyManager.NETWORK_TYPE_HSPA,
                        TelephonyManager.NETWORK_TYPE_EVDO_B,
                        TelephonyManager.NETWORK_TYPE_EHRPD,
                        TelephonyManager.NETWORK_TYPE_HSPAP -> TYPE_MOBILE_3G

                        TelephonyManager.NETWORK_TYPE_LTE -> TYPE_MOBILE_4G

                        else -> TYPE_MOBILE_UNKNOWN
                    }
                    else -> TYPE_NOT_CONNECTED
                }
            }
            return TYPE_NOT_CONNECTED
        }

    val isConnected: Boolean
        get() = connectivityStatus != TYPE_NOT_CONNECTED

    companion object {
        const val TYPE_WIFI = 1
        const val TYPE_MOBILE_2G = 2
        const val TYPE_MOBILE_3G = 3
        const val TYPE_MOBILE_4G = 4
        const val TYPE_MOBILE_UNKNOWN = 5
        const val TYPE_NOT_CONNECTED = 0
    }

}

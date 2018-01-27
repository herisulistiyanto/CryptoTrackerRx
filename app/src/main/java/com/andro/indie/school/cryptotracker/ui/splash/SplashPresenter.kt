package com.andro.indie.school.cryptotracker.ui.splash

import com.andro.indie.school.cryptotracker.network.NetworkUtils

/**
 * Created by herisulistiyanto on 1/13/18.
 */
class SplashPresenter(private val splashView: SplashView, private val networkUtils: NetworkUtils) {

    fun checkRequirement() {
        when {
            networkUtils.isConnected -> {
                splashView.navigateToHome()
            }
            else -> splashView.showInternetError()
        }
    }

}
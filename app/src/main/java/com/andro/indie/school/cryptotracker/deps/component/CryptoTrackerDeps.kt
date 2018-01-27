package com.andro.indie.school.cryptotracker.deps.component

import com.andro.indie.school.cryptotracker.CryptoTrackerApp
import com.andro.indie.school.cryptotracker.deps.module.AppModule
import com.andro.indie.school.cryptotracker.deps.module.CryptoNetworkModule
import com.andro.indie.school.cryptotracker.ui.home.HomeActivity
import com.andro.indie.school.cryptotracker.ui.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by herisulistiyanto on 1/13/18.
 */
@Singleton
@Component(modules = [
    (AppModule::class),
    (CryptoNetworkModule::class)
])
interface CryptoTrackerDeps {

    fun inject(cryptoTrackerApp: CryptoTrackerApp)

    fun inject(splashActivity: SplashActivity)

    fun inject(homeActivity: HomeActivity)
}
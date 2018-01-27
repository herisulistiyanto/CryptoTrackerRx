package com.andro.indie.school.cryptotracker

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import com.andro.indie.school.cryptotracker.deps.component.CryptoTrackerDeps
import com.andro.indie.school.cryptotracker.deps.component.DaggerCryptoTrackerDeps
import com.andro.indie.school.cryptotracker.deps.module.AppModule

/**
 * Created by herisulistiyanto on 1/13/18.
 */
@Suppress("DEPRECATION")
class CryptoTrackerApp: Application() {

    lateinit var cryptoDeps: CryptoTrackerDeps

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        cryptoDeps = DaggerCryptoTrackerDeps.builder()
                .appModule(AppModule(this))
                .build()
        cryptoDeps.inject(this)
    }

}
package com.andro.indie.school.cryptotracker.deps.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by herisulistiyanto on 1/13/18.
 */
@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }

}
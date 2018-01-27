package com.andro.indie.school.cryptotracker.network

import com.andro.indie.school.cryptotracker.model.CurrencyModel
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by herisulistiyanto on 1/13/18.
 */
interface NetworkServices {

    @GET("v1/ticker/?convert=IDR&limit=15")
    fun getAllCurrency(): Flowable<List<CurrencyModel>>

}
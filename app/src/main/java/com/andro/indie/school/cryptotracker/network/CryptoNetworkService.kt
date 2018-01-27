package com.andro.indie.school.cryptotracker.network

import com.andro.indie.school.cryptotracker.extensions.uiSubscribe
import com.andro.indie.school.cryptotracker.model.CurrencyModel
import io.reactivex.disposables.Disposable

/**
 * Created by herisulistiyanto on 1/14/18.
 */
class CryptoNetworkService(private val networkServices: NetworkServices) {

    fun getAllCurrency(onSuccess: (List<CurrencyModel>) -> Unit,
                       onError: (Throwable) -> Unit): Disposable {
        return networkServices.getAllCurrency()
                .uiSubscribe(
                        onNext = { onSuccess(it) },
                        onError = { onError(it) }
                )
    }
}
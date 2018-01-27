package com.andro.indie.school.cryptotracker.ui.home

import com.andro.indie.school.cryptotracker.extensions.safeDispose
import com.andro.indie.school.cryptotracker.network.CryptoNetworkService
import com.andro.indie.school.cryptotracker.network.NetworkUtils
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by herisulistiyanto on 1/14/18.
 */
class HomePresenter(private val homeView: HomeView,
                    private val service: CryptoNetworkService,
                    private val networkUtils: NetworkUtils) {

    private val disposables = CompositeDisposable()

    fun getAllCurrencies() {
        when {
            networkUtils.isConnected -> {
                homeView.updateProgressVisibility(true)
                disposables.add(service.getAllCurrency(
                        onSuccess = { response ->
                            homeView.disablePullToRefreshProgress()
                            homeView.updateProgressVisibility(false)
                            if (response.isNotEmpty()) {
                                val sortedList = response.sortedWith(compareBy {
                                    it.rank?.toInt()
                                })
                                homeView.updateData(sortedList)
                            }
                        },
                        onError = {
                            homeView.disablePullToRefreshProgress()
                            homeView.updateProgressVisibility(false)
                            homeView.showError(it)
                        }))
            }
            else -> {
                homeView.disablePullToRefreshProgress()
                homeView.showInternetError()
            }
        }
    }

    fun onDestroy() {
        disposables.safeDispose()
    }

}
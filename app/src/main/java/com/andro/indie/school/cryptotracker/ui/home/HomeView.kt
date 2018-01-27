package com.andro.indie.school.cryptotracker.ui.home

import com.andro.indie.school.cryptotracker.model.CurrencyModel

/**
 * Created by herisulistiyanto on 1/14/18.
 */
interface HomeView {

    fun updateProgressVisibility(visible: Boolean)

    fun showInternetError()

    fun updateData(response: List<CurrencyModel>)

    fun showError(error: Throwable)

    fun disablePullToRefreshProgress()

    fun refreshList()

}
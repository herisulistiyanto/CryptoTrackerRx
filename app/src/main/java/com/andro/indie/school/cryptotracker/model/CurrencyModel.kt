package com.andro.indie.school.cryptotracker.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by herisulistiyanto on 1/13/18.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class CurrencyModel(
        @SerializedName("id") val id: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("symbol") val symbol: String?,
        @SerializedName("rank") val rank: String?,
        @SerializedName("price_usd") val priceUsd: String?,
        @SerializedName("price_btc") val priceBtc: String?,
        @SerializedName("24h_volume_usd") val dailyVolumeUsd: String?,
        @SerializedName("market_cap_usd") val marketCapUsd: String?,
        @SerializedName("available_supply") val availableSupply: String?,
        @SerializedName("total_supply") val totalSupply: String?,
        @SerializedName("max_supply") val maxSupply: String?,
        @SerializedName("percent_change_1h") val hourPercentChange: String?,
        @SerializedName("percent_change_24h") val dayPercentChange: String?,
        @SerializedName("percent_change_7d") val weekPercentChange: String?,
        @SerializedName("last_updated") val lastUpdated: String?,
        @SerializedName("price_idr") val priceIdr: String?,
        @SerializedName("24h_volume_idr") val dailyVolumeIdr: String?,
        @SerializedName("market_cap_idr") val marketCapIdr: String?
) : Parcelable
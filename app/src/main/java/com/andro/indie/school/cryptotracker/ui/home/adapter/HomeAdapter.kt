package com.andro.indie.school.cryptotracker.ui.home.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andro.indie.school.cryptotracker.R
import com.andro.indie.school.cryptotracker.extensions.getColorCompat
import com.andro.indie.school.cryptotracker.extensions.getDrawableCompat
import com.andro.indie.school.cryptotracker.extensions.safeToLong
import com.andro.indie.school.cryptotracker.extensions.unixToDate
import com.andro.indie.school.cryptotracker.model.CurrencyModel
import kotlinx.android.synthetic.main.layout_crypto_item.view.*

/**
 * Created by herisulistiyanto on 1/14/18.
 */
class HomeAdapter(val items: MutableList<CurrencyModel>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var listener: HolderListener? = null

    companion object {
        const val MINUS = "-"
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder {
        val rootView = LayoutInflater.from(parent?.context).inflate(R.layout.layout_crypto_item,
                parent, false)
        return HomeViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
        holder?.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    fun updateListData(newItems: List<CurrencyModel>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(item: CurrencyModel, listener: HolderListener?) {
            with(itemView) {
                tvCode.text = "(${item.symbol})"
                tvName.text = item.name
                tvPrice.text = "$${item.priceUsd}"
                item.dayPercentChange?.let {
                    tvStatsDaily.text = "$it %"
                    val textColor = if (it.contains(MINUS)) R.color.lightRed else R.color.lightTextGreen
                    tvStatsDaily.setTextColor(context.getColorCompat(textColor))
                    val arrowStats = if (it.contains(MINUS)) R.drawable.ic_arrow_downward else R.drawable.ic_arrow_upward
                    ivIndicatorDaily.setImageDrawable(itemView.context.getDrawableCompat(arrowStats))
                }
                item.weekPercentChange?.let {
                    tvStatsWeekly.text = "$it %"
                    val textColor = if (it.contains(MINUS)) R.color.lightRed else R.color.lightTextGreen
                    tvStatsWeekly.setTextColor(context.getColorCompat(textColor))
                    val arrowStats = if (it.contains(MINUS)) R.drawable.ic_arrow_downward else R.drawable.ic_arrow_upward
                    ivIndicatorWeekly.setImageDrawable(itemView.context.getDrawableCompat(arrowStats))
                }
                item.hourPercentChange?.let {
                    tvStatsHourly.text = "$it %"
                    val textColor = if (it.contains(MINUS)) R.color.lightRed else R.color.lightTextGreen
                    tvStatsHourly.setTextColor(context.getColorCompat(textColor))
                    val arrowStats = if (it.contains(MINUS)) R.drawable.ic_arrow_downward else R.drawable.ic_arrow_upward
                    ivIndicatorHourly.setImageDrawable(itemView.context.getDrawableCompat(arrowStats))
                }
                item.lastUpdated?.let {
                    val unixTimestamp = it.safeToLong()
                    tvLastUpdate.text = unixTimestamp.unixToDate()
                }
                setOnClickListener { listener?.onClickHolder(adapterPosition) }
            }

        }
    }

    interface HolderListener {
        fun onClickHolder(position: Int)
    }
}
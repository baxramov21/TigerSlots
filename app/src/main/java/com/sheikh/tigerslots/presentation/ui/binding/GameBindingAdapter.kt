package com.sheikh.tigerslots.presentation.ui.binding

import android.content.res.Resources
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.sheikh.tigerslots.R

@BindingAdapter("showDeposit")
fun bindDeposit(textView: TextView, deposit: Int) {
    val depositText = String.format(getResources(textView).getString(R.string.cash), deposit)
    textView.text = depositText
}

@BindingAdapter("showBetAmount")
fun bindBetAmount(textView: TextView, betAmount: Int) {
    val betAmountText =
        String.format(getResources(textView).getString(R.string.bet_amount), betAmount)
    textView.text = betAmountText
}

@BindingAdapter("showWinAmount")
fun bindWinAmount(textView: TextView, profit: Int) {
    val winAmountText =
        String.format(getResources(textView).getString(R.string.win_amount), profit)
    textView.text = winAmountText
}


private fun getResources(textView: TextView): Resources = textView.context.resources

package com.e17cn2.threetree.android.presentation

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.e17cn2.threetree.android.view.PlayingCardView
import com.e17cn2.threetree.entity.SuiteCard
import timber.log.Timber

@BindingAdapter("app:list")
fun setList(recyclerView: RecyclerView, list: List<Any>?) {
    if (list != null && recyclerView.adapter != null) {
        Timber.d("list $list")
        (recyclerView.adapter as ListAdapter<Any, *>).submitList(list)
    }
}

@BindingAdapter("app:cardSuite")
fun setCardSuite(playingCardView: PlayingCardView, suite: SuiteCard?) {
    if (suite != null) {
        Timber.d("setCardSuite $suite")
        playingCardView.setSuite(suite)
    }
}

@BindingAdapter("app:cardValue")
fun setCardValue(playingCardView: PlayingCardView, value: Int?) {
    if (value != null) {
        Timber.d("setCardValue $value")
        playingCardView.setValue(value)
    }
}
package com.e17cn2.threetree.android.presentation

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

@BindingAdapter("app:list")
fun setList(recyclerView: RecyclerView, list: List<Any>?) {
    if (list != null && recyclerView.adapter != null) {
        Timber.d("list $list")
        (recyclerView.adapter as ListAdapter<Any, *>).submitList(list)
    }
}
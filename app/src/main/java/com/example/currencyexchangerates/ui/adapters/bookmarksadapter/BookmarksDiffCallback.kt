package com.example.currencyexchangerates.ui.adapters.bookmarksadapter

import androidx.recyclerview.widget.DiffUtil
import com.example.currencyexchangerates.ui.model.UIBookmark

class BookmarksDiffCallback : DiffUtil.ItemCallback<UIBookmark>() {
    override fun areItemsTheSame(oldItem: UIBookmark, newItem: UIBookmark): Boolean {
        return oldItem.shortName == newItem.name && oldItem.base == newItem.base
    }

    override fun areContentsTheSame(oldItem: UIBookmark, newItem: UIBookmark): Boolean {
        return oldItem.value == newItem.value
    }
}
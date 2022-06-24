package com.example.currencyexchangerates.ui.adapters.bookmarksadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchangerates.databinding.ItemBookmarkBinding
import com.example.currencyexchangerates.ui.model.UIBookmark

class BookmarksViewHolder(val binding: ItemBookmarkBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: UIBookmark) {
        binding.apply {
            tvCurrencyPair.text = "${item.base}/${item.shortName}"
            tvCurrentCourse.text = item.value
            isBookmark.crossfade = 1f
        }
    }

    companion object {
        fun from(parent: ViewGroup): BookmarksViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemBookmarkBinding.inflate(inflater, parent, false)
            return BookmarksViewHolder(binding)
        }
    }
}
package com.example.currencyexchangerates.ui.adapters.bookmarksadapter


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.currencyexchangerates.ui.model.UIBookmark

class BookmarksAdapter(private val click: (UIBookmark) -> Unit) :
    ListAdapter<UIBookmark, BookmarksViewHolder>(BookmarksDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarksViewHolder {
        val vh = BookmarksViewHolder.from(parent)
        vh.binding.isBookmark.setOnClickListener {
            val item = currentList[vh.absoluteAdapterPosition]
            click.invoke(item)
            vh.binding.isBookmark.crossfade = 0f
        }
        return vh
    }

    override fun onBindViewHolder(holder: BookmarksViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
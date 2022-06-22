package com.example.currencyexchangerates.ui.adapters


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.currencyexchangerates.ui.model.UIItemCurrency

class CurrencyAdapter(private val click: (UIItemCurrency) -> Unit) :
    ListAdapter<UIItemCurrency, CurrencyViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val vh = CurrencyViewHolder.from(parent)
        vh.binding.isBookmark?.setOnClickListener {
            val item = currentList[vh.absoluteAdapterPosition]
            val newItem = item.copy(isBookmark = !item.isBookmark)
            val newList = currentList.toMutableList()
            newList[vh.absoluteAdapterPosition] = newItem
            submitList(newList)
            click.invoke(newItem)
            vh.binding.isBookmark.crossfade = if (newItem.isBookmark) 1f else 0f
        }
        return vh
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
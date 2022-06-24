package com.example.currencyexchangerates.ui.adapters.currencyadapter

import androidx.recyclerview.widget.DiffUtil
import com.example.currencyexchangerates.ui.model.UIItemCurrency

class DiffCallback : DiffUtil.ItemCallback<UIItemCurrency>() {
    override fun areItemsTheSame(oldItem: UIItemCurrency, newItem: UIItemCurrency): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: UIItemCurrency, newItem: UIItemCurrency): Boolean {
        return oldItem.value == newItem.value && oldItem.isBookmark == newItem.isBookmark
    }
}
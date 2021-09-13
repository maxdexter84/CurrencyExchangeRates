package com.example.currencyexchangerates.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.currencyexchangerates.ui.model.UICurrency

class DiffCallback : DiffUtil.ItemCallback<UICurrency>() {
    override fun areItemsTheSame(oldItem: UICurrency, newItem: UICurrency): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UICurrency, newItem: UICurrency): Boolean {
        return oldItem == newItem
    }
}
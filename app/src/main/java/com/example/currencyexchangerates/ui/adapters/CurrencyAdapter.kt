package com.example.currencyexchangerates.ui.adapters


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.currencyexchangerates.ui.entity.UICurrency

class CurrencyAdapter : ListAdapter<UICurrency, CurrencyViewHolder>(DiffCallback()) {


    class DiffCallback : DiffUtil.ItemCallback<UICurrency>() {
        override fun areItemsTheSame(oldItem: UICurrency, newItem: UICurrency): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UICurrency, newItem: UICurrency): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
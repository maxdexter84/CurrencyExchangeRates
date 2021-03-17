package com.example.currencyexchangerates.ui.adapters


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.currencyexchangerates.ui.entity.UICurrency
import androidx.recyclerview.widget.ListAdapter

class CurrencyAdapter(private val itemListener: ItemListener): ListAdapter<UICurrency,CurrencyViewHolder>(DiffCallback()) {

    interface ItemListener{
        fun click(uuid: String)
    }

    class DiffCallback : DiffUtil.ItemCallback<UICurrency>() {
        override fun areItemsTheSame(oldItem: UICurrency, newItem: UICurrency): Boolean {
            return  oldItem.iD == newItem.iD
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
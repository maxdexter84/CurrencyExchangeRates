package com.example.currencyexchangerates.ui.adapters


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.currencyexchangerates.ui.model.UICurrency

class CurrencyAdapter(private val click: (UICurrency) -> Unit) :
    ListAdapter<UICurrency, CurrencyViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val vh = CurrencyViewHolder.from(parent)
        vh.itemView.setOnClickListener {
            click.invoke(currentList[vh.absoluteAdapterPosition])
        }
        return vh
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
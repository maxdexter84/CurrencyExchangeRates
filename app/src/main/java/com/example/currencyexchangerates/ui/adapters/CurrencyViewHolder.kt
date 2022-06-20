package com.example.currencyexchangerates.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchangerates.databinding.ItemCurrencyBinding
import com.example.currencyexchangerates.ui.model.UICurrency
import com.example.currencyexchangerates.ui.model.UIItemCurrency

class CurrencyViewHolder(private val binding: ItemCurrencyBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: UIItemCurrency) {
        binding.apply {
            tvCurrencyName.text = item.name
            tvCurrencyUnit.text = "1"
            tvCurrentCourse.text = item.value
            tvCurrencyCode.text = ""
        }
    }

    companion object {
        fun from(parent: ViewGroup): CurrencyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemCurrencyBinding.inflate(inflater, parent, false)
            return CurrencyViewHolder(binding)
        }
    }
}
package com.example.currencyexchangerates.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchangerates.databinding.ItemCurrencyBinding
import com.example.currencyexchangerates.ui.entity.UICurrency

class CurrencyViewHolder(private val binding: ItemCurrencyBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: UICurrency){
        binding.currency = item
        binding.executePendingBindings()
        binding.setClickListener {
            Log.i("ADAPTER", "click")
        }
    }

    companion object{
        fun from(parent: ViewGroup): CurrencyViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemCurrencyBinding.inflate(inflater,parent,false)
            return CurrencyViewHolder(binding)
        }
    }
}
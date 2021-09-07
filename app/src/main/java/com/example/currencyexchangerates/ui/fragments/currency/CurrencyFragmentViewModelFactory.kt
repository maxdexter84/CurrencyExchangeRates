package com.example.currencyexchangerates.ui.fragments.currency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchangerates.domain.repository.IRepository

class CurrencyFragmentViewModelFactory(private val repository: IRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrencyViewModel(repository) as T
    }
}
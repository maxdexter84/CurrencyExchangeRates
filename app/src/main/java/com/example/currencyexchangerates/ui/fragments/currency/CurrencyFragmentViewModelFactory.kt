package com.example.currencyexchangerates.ui.fragments.currency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchangerates.domain.repository.Repository

class CurrencyFragmentViewModelFactory(private val repository: Repository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrencyViewModel(repository) as T
    }
}
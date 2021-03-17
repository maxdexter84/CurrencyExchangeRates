package com.example.currencyexchangerates.ui.fragments.currency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangerates.repository.IRepository
import com.example.currencyexchangerates.ui.entity.UICurrency
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CurrencyViewModel(private val repository: IRepository) : ViewModel() {

    private val _currencyList = MutableLiveData<List<UICurrency>>(emptyList())
    val currencyList: LiveData<List<UICurrency>>
        get() = _currencyList

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _currencyList.value = repository.getData()
        }

    }
}
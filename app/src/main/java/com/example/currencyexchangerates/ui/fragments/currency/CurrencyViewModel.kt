package com.example.currencyexchangerates.ui.fragments.currency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangerates.domain.repository.Repository
import com.example.currencyexchangerates.ui.entity.UICurrency
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CurrencyViewModel(private val repository: Repository) : ViewModel() {

    private val _currencyList = MutableLiveData<List<UICurrency>>(emptyList())
    val currencyList: LiveData<List<UICurrency>>
        get() = _currencyList

    init {
        getData()
    }

    fun getData() {
        _currencyList.value = emptyList()
        viewModelScope.launch {
            repository.getData().collect {
                delay(100)
                _currencyList.value = it
            }
        }

    }
}
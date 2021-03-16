package com.example.currencyexchangerates.ui.currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.databinding.FragmentCurrencyListBinding

class CurrencyFragment : Fragment() {

    private val currencyViewModel: CurrencyViewModel by lazy {
        ViewModelProvider(this).get(CurrencyViewModel::class.java)
    }
    private lateinit var binding: FragmentCurrencyListBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

       binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_currency_list, container, false)


        return binding.root
    }
}
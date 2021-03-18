package com.example.currencyexchangerates.ui.fragments.calculator

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.databinding.FragmentCalculatorDialogBinding


class CalculatorDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCalculatorDialogBinding

    private val viewModel: CalculatorViewModel by lazy {
        ViewModelProvider(this).get(CalculatorViewModel::class.java)
    }

    private val args: CalculatorDialogFragmentArgs? by lazy {
        arguments?.let { CalculatorDialogFragmentArgs.fromBundle(it) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_calculator_dialog,container, false)


        initCalculate()
        initTV()
        return binding.root
    }

    private fun initTV() {
        binding.tvCurrencyName.text = args?.uiCurrency?.name
        viewModel.calculateRes.observe(viewLifecycleOwner, {
            binding.tvValute.text = it

        })
    }

    private fun initCalculate() {
        val nominal = args?.uiCurrency?.nominal ?: ""
        val value = args?.uiCurrency?.value ?: ""
        binding.etRub.doAfterTextChanged {
            viewModel.calculate(nominal, value, it.toString())
        }
    }


}
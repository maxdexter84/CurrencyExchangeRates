package com.example.currencyexchangerates.ui.fragments.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding

    private val viewModel: CalculatorViewModel by lazy {
        ViewModelProvider(this).get(CalculatorViewModel::class.java)
    }

    private val args: CalculatorFragmentArgs? by lazy {
        arguments?.let { CalculatorFragmentArgs.fromBundle(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calculator, container, false)

        binding.toolbar2.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
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
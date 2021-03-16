package com.example.currencyexchangerates.ui.fragments.settings

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
import com.example.currencyexchangerates.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private val settingsViewModel: SettingsViewModel by lazy {
        ViewModelProvider(this).get(SettingsViewModel::class.java)
    }
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_settings, container, false)

        return binding.root
    }
}
package com.example.currencyexchangerates.ui.fragments.currency

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.data.locale.AppDatabase
import com.example.currencyexchangerates.data.locale.LocalRepositoryImpl
import com.example.currencyexchangerates.data.remote.CurrencyApi
import com.example.currencyexchangerates.data.remote.RemoteRepositoryImpl
import com.example.currencyexchangerates.databinding.FragmentCurrencyListBinding
import com.example.currencyexchangerates.domain.repository.LocalRepository
import com.example.currencyexchangerates.domain.repository.RemoteRepository
import com.example.currencyexchangerates.domain.usecaseimpl.GetCurrenciesUseCaseImpl
import com.example.currencyexchangerates.domain.usecaseimpl.SaveCurrenciesUseCaseImpl
import com.example.currencyexchangerates.ui.adapters.CurrencyAdapter


class CurrencyFragment : Fragment() {


    private val currencyViewModel: CurrencyViewModel by lazy {
        val remoteRepository: RemoteRepository = RemoteRepositoryImpl(CurrencyApi.currencyService)
        val localRepository: LocalRepository = LocalRepositoryImpl(
            AppDatabase.invoke(requireContext()).getCurrencyDao()
        )

        val getCurrenciesUseCase = GetCurrenciesUseCaseImpl(remoteRepository, localRepository)
        val saveCurrenciesUseCase = SaveCurrenciesUseCaseImpl(localRepository)
        ViewModelProvider(
            this,
            CurrencyFragmentViewModelFactory(getCurrenciesUseCase, saveCurrenciesUseCase)
        ).get(CurrencyViewModel::class.java)
    }

    private val currencyAdapter: CurrencyAdapter by lazy {
        CurrencyAdapter {
            CurrencyFragmentDirections.actionCurrencyFragmentToCalculatorDialogFragment(it)
        }
    }

    private var _binding: FragmentCurrencyListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyListBinding.inflate(layoutInflater)

        initSwipeRefresh()
        initRecycler()
        return binding.root
    }


    @SuppressLint("ResourceAsColor")
    private fun initSwipeRefresh() {
        binding.swipeRefresh.setProgressBackgroundColorSchemeColor(R.color.reply_orange_300)
        binding.swipeRefresh.setOnRefreshListener {
            currencyViewModel.loadData()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun initRecycler() {
        binding.rvCurrencyList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCurrencyList.adapter = currencyAdapter
        currencyViewModel.currencyList.observe(viewLifecycleOwner, {
            currencyAdapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.currencyexchangerates.ui.fragments.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.currencyexchangerates.databinding.FragmentBookmarksBinding
import com.example.currencyexchangerates.ui.adapters.bookmarksadapter.BookmarksAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class BookmarksFragment : Fragment() {

    private var _binding: FragmentBookmarksBinding? = null
    private val binding get() = _binding!!

    private val adapter = BookmarksAdapter {
        viewModel.deleteBookmark(it)
    }

    private val viewModel: BookmarksViewModel by lazy {
        ViewModelProvider(this)[BookmarksViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarksBinding.inflate(layoutInflater)
        bookmarksListObserver()
        loadStateObserver()
        binding.rvBookmarks.adapter = adapter
        return binding.root
    }

    private fun loadStateObserver() {
        viewModel.loadingState.onEach {
            binding.swipeRefresh.isRefreshing = it
        }.launchIn(lifecycleScope)
    }

    private fun bookmarksListObserver() {
        viewModel.bookmarksList.onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)
    }

}
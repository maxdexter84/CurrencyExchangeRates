package com.example.currencyexchangerates.ui.fragments.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.currencyexchangerates.R
import com.example.currencyexchangerates.databinding.FragmentBookmarksBinding

class BookmarkFragment : Fragment() {

    private val bookmarkViewModel: BookmarkViewModel by lazy {
        ViewModelProvider(this).get(BookmarkViewModel::class.java)
    }

    private lateinit var binding: FragmentBookmarksBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_bookmarks, container, false)

        return binding.root
    }
}
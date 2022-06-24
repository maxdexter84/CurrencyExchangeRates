package com.example.currencyexchangerates.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currencyexchangerates.data.locale.dao.BookmarkDao
import com.example.currencyexchangerates.data.model.localeCurrency.Bookmark

@Database(entities = [Bookmark::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getBookmarkDao(): BookmarkDao
}

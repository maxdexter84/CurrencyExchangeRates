package com.example.currencyexchangerates.data.locale

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark

@Dao
interface BookmarkDao {

    @Insert
    suspend fun saveBookmark(bookmark: Bookmark)

    @Delete
    suspend fun deleteBookmark(bookmark: Bookmark)
}
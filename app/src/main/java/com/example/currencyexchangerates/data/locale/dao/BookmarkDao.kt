package com.example.currencyexchangerates.data.locale.dao

import androidx.room.*
import com.example.currencyexchangerates.data.model.localeCurrency.Bookmark
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBookmark(bookmark: Bookmark)

    @Delete
    suspend fun deleteBookmark(bookmark: Bookmark)

    @Query("SELECT * FROM bookmark")
    fun getBookmarks(): Flow<List<Bookmark>>
}
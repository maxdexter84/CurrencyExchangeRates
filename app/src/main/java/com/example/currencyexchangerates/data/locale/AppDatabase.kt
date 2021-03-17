package com.example.currencyexchangerates.data.locale

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.currencyexchangerates.data.entity.localeCurrency.Bookmark
import com.example.currencyexchangerates.data.entity.localeCurrency.DbCurrency
import com.example.currencyexchangerates.data.locale.dao.BookmarkDao
import com.example.currencyexchangerates.data.locale.dao.CurrencyDao

@Database(entities = [DbCurrency::class,Bookmark::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCurrencyDao(): CurrencyDao
    abstract fun getBookmarkDao(): BookmarkDao


    companion object{
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it}
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java,
            "app_db.db").build()
    }
}

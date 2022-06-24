package com.example.currencyexchangerates.di.modules

import android.content.Context
import androidx.room.Room
import com.example.currencyexchangerates.data.locale.AppDatabase
import com.example.currencyexchangerates.data.locale.dao.BookmarkDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideBookmarkDao(database: AppDatabase): BookmarkDao {
        return database.getBookmarkDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_db.db"
    ).build()
}
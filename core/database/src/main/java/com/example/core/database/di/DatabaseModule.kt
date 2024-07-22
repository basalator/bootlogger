package com.example.core.database.di

import android.content.Context
import androidx.room.Room
import com.example.core.database.BootLoggerDatabase
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
    @Singleton
    fun providesSoberDatabase(
        @ApplicationContext context: Context,
    ): BootLoggerDatabase = Room.databaseBuilder(
        context,
        BootLoggerDatabase::class.java,
        "bootlogger-database",
    ).build()
}

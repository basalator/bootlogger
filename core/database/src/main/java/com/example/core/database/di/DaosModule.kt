package com.example.core.database.di

import com.example.core.database.BootLoggerDatabase
import com.example.core.database.bootlogs.BootRecordsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesBootRecordsDao(
        database: BootLoggerDatabase,
    ): BootRecordsDao = database.recordsDao()
}

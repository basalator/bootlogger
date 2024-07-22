package com.example.core.data.di

import android.content.Context
import com.example.core.data.BootRecordsRepository
import com.example.core.data.BootRecordsRepositoryImpl
import com.example.core.data.datasource.BootRecordsLocalDataSource
import com.example.core.data.datasource.BootRecordsLocalDataSourceImpl
import com.example.core.database.bootlogs.BootRecordsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideLocalDataSource(dao: BootRecordsDao): BootRecordsLocalDataSource = BootRecordsLocalDataSourceImpl(dao)

    @Provides
    fun provideRepository(localDataSource: BootRecordsLocalDataSource): BootRecordsRepository =
        BootRecordsRepositoryImpl(localDataSource)
}
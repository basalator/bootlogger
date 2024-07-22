package com.example.core.common

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.plus
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @DispatcherIo
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @DispatcherMain
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @DispatcherDef
    @Provides
    fun provideDefDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @AppScope
    @Singleton
    @Provides
    fun provideAppScope(@DispatcherDef dispatcher: CoroutineDispatcher): CoroutineScope =
        MainScope().plus(dispatcher)
}

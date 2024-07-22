package com.example.core.common

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherIo

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherMain

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherDef


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TestBuild
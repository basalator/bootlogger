package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.withTransaction
import com.example.core.database.bootlogs.BootRecordEntity
import com.example.core.database.bootlogs.BootRecordsDao

@Database(
    entities = [
        BootRecordEntity::class,
    ],
    version = 1
)
@TypeConverters(CommonTypeConverters::class)
abstract class BootLoggerDatabase : RoomDatabase() {

    abstract fun recordsDao(): BootRecordsDao

    suspend fun <R> transaction(block: suspend (db: BootLoggerDatabase) -> R) {
        withTransaction {
            block(this)
        }
    }
}
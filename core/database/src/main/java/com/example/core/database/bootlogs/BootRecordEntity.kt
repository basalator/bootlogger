package com.example.core.database.bootlogs

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.model.BootRecord
import java.time.LocalDateTime

@Entity(tableName = "boot_records")
data class BootRecordEntity(

    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "timestamp") val timestamp: LocalDateTime,
)

fun BootRecordEntity.toModel() = BootRecord(
    id = id,
    timestamp = timestamp,
)

fun BootRecord.toEntity() = BootRecordEntity(
    id = id,
    timestamp = timestamp,
)
package com.example.core.database

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

object CommonTypeConverters {

    @TypeConverter
    @JvmStatic
    fun toLocalDateTime(value: Long?): LocalDateTime? = value?.toLocalDateTime()

    @TypeConverter
    @JvmStatic
    fun fromLocalDateTime(value: LocalDateTime?): Long? = value?.toMillis()

    private fun LocalDateTime.toMillis() =
        this.atZone(ZoneId.of("UTC")).toEpochSecond().let { it * 1000L }

    private fun Long.toLocalDateTime(): LocalDateTime =
        Instant.ofEpochMilli(this).atZone(ZoneId.of("UTC")).toLocalDateTime()
}
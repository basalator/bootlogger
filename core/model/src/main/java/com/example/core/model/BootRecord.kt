package com.example.core.model

import java.sql.Timestamp
import java.time.LocalDateTime

data class BootRecord(
    val id: String,
    val timestamp: LocalDateTime,
)
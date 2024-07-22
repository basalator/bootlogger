package com.example.core.data.datasource

import com.example.core.model.BootRecord
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface BootRecordsLocalDataSource {

    fun getBootRecordById(id: String): Flow<BootRecord>

    fun getBootRecords(dateStart: LocalDateTime, dateEnd: LocalDateTime): Flow<List<BootRecord>>

    fun getBootRecordsCount(dateStart: LocalDateTime, dateEnd: LocalDateTime): Flow<Long>

    suspend fun putRecord(record: BootRecord)

    suspend fun deleteRecord(recordId: String)

}
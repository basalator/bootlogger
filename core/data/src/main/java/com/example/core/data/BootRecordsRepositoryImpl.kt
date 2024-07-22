package com.example.core.data

import com.example.core.data.datasource.BootRecordsLocalDataSource
import com.example.core.model.BootRecord
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

internal class BootRecordsRepositoryImpl(private val localDataSource: BootRecordsLocalDataSource): BootRecordsRepository {
    override fun getBootRecordById(id: String): Flow<BootRecord> = localDataSource.getBootRecordById(id)

    override fun getBootRecords(
        dateStart: LocalDateTime?,
        dateEnd: LocalDateTime?
    ): Flow<List<BootRecord>> = localDataSource.getBootRecords(dateStart, dateEnd)

    override fun getBootRecordsCount(
        dateStart: LocalDateTime?,
        dateEnd: LocalDateTime?
    ): Flow<Long> = localDataSource.getBootRecordsCount(dateStart, dateEnd)

    override suspend fun putRecord(record: BootRecord) = localDataSource.putRecord(record)

    override suspend fun deleteRecord(recordId: String) = localDataSource.deleteRecord(recordId)
}
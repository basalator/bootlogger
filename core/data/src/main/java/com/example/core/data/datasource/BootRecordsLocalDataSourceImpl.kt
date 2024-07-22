package com.example.core.data.datasource

import com.example.core.database.bootlogs.BootRecordsDao
import com.example.core.database.bootlogs.toEntity
import com.example.core.database.bootlogs.toModel
import com.example.core.model.BootRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime


internal class BootRecordsLocalDataSourceImpl(private val dao: BootRecordsDao): BootRecordsLocalDataSource {

    override fun getBootRecordById(id: String): Flow<BootRecord> = dao.get(id).map { it?.toModel()!! }

    override fun getBootRecords(
        dateStart: LocalDateTime?,
        dateEnd: LocalDateTime?
    ): Flow<List<BootRecord>> = dao.get(dateStart, dateEnd).map { list -> list.mapNotNull { it?.toModel() } }

    override fun getBootRecordsCount(
        dateStart: LocalDateTime?,
        dateEnd: LocalDateTime?
    ): Flow<Long> = dao.getCount(dateStart, dateEnd)

    override suspend fun putRecord(record: BootRecord) {
       dao.insert(record.toEntity())
    }

    override suspend fun deleteRecord(recordId: String) {
        dao.delete(recordId)
    }
}
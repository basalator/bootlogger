package com.example.core.domain

import com.example.core.common.DispatcherDef
import com.example.core.data.BootRecordsRepository
import com.example.core.model.BootRecord
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject

class DeleteBootRecordUseCase @Inject constructor(
    @DispatcherDef
    private val dispatcher: CoroutineDispatcher,
    private val bootRecordsRepository: BootRecordsRepository,
) {

    suspend operator fun invoke(recordId: String) = withContext(dispatcher) {
        bootRecordsRepository.deleteRecord(recordId)
    }
}
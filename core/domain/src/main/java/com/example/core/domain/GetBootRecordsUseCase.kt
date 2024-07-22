package com.example.core.domain

import com.example.core.common.DispatcherDef
import com.example.core.data.BootRecordsRepository
import com.example.core.model.BootRecord
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDateTime
import javax.inject.Inject

class GetBootRecordsUseCase @Inject constructor(
    @DispatcherDef
    private val dispatcher: CoroutineDispatcher,
    private val bootRecordsRepository: BootRecordsRepository,
) {

    operator fun invoke(
        dateStart: LocalDateTime? = null,
        dateEnd: LocalDateTime? = null
    ): Flow<List<BootRecord>> =
        bootRecordsRepository.getBootRecords(dateStart, dateEnd)
            .flowOn(dispatcher)
            .catch { emit(emptyList()) }
}
package com.example.core.domain

import com.example.core.common.DispatcherDef
import com.example.core.data.BootRecordsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDateTime
import javax.inject.Inject

class GetBootRecordsCountUseCase @Inject constructor(
    @DispatcherDef
    private val dispatcher: CoroutineDispatcher,
    private val bootRecordsRepository: BootRecordsRepository,
) {

    operator fun invoke(dateStart: LocalDateTime, dateEnd: LocalDateTime): Flow<Long> =
        bootRecordsRepository.getBootRecordsCount(dateStart, dateEnd)
            .flowOn(dispatcher)
            .catch { emit(0) }
}
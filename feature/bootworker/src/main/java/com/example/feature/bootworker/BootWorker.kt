package com.example.feature.bootworker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.example.core.domain.CreateBootRecordUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

@HiltWorker
class BootWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val createBootRecordUseCase: CreateBootRecordUseCase,
) : CoroutineWorker(context, workerParameters) {

    companion object {

        const val tagPeriodic = "tagPeriodic"
        const val tagSingle = "tagSingle"
        fun enqueuePeriodic(context: Context) {
            // every day at 12PM
            val delay = ChronoUnit.SECONDS.between(
                LocalDateTime.now(),
                LocalDate.now().plusDays(1).atStartOfDay()
            )
            val manager = WorkManager.getInstance(context)
            val requestBuilder =
                PeriodicWorkRequestBuilder<BootWorker>(15L, TimeUnit.MINUTES).apply { // TODO get period from ui
                    addTag("BootWorker")
                    setInitialDelay(delay, TimeUnit.SECONDS)
                }

            manager.enqueueUniquePeriodicWork(
                tagPeriodic,
                ExistingPeriodicWorkPolicy.UPDATE,
                requestBuilder.build(),
            )
        }

        fun enqueueSingle(context: Context) {
            val manager = WorkManager.getInstance(context)

            manager.enqueueUniqueWork(
                tagSingle,
                ExistingWorkPolicy.REPLACE,
                OneTimeWorkRequestBuilder<BootWorker>().apply {
                    addTag("BootWorkerSingle")
                    setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                }.build(),
            )
        }


        fun cancel(context: Context) {
            WorkManager.getInstance(context).cancelAllWorkByTag(tagPeriodic)
        }

        fun cancelSingle(context: Context) {
            WorkManager.getInstance(context).cancelAllWorkByTag(tagSingle)
        }
    }

    override suspend fun doWork(): Result {
        // TODO add creation logic
        return Result.success()
    }
}
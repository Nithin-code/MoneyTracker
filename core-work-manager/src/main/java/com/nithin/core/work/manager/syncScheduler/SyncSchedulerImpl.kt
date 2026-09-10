package com.nithin.core.work.manager.syncScheduler

import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.nithin.core.common.workmanager.SyncScheduler
import com.nithin.core.work.manager.PaymentSyncWorker

class SyncSchedulerImpl(
    private val workManager: WorkManager
): SyncScheduler {
    override suspend fun scheduleSync() {
        val constraints = Constraints
            .Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val request = OneTimeWorkRequestBuilder<PaymentSyncWorker>()
            .setConstraints(constraints)
            .setBackoffCriteria(
                BackoffPolicy.EXPONENTIAL,
                30,
                java.util.concurrent.TimeUnit.SECONDS
            ).build()

        workManager.enqueueUniqueWork(
            "payment_sync",
            ExistingWorkPolicy.KEEP,
            request
        )
    }
}
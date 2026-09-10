package com.nithin.core.work.manager.delete_payment_worker

import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.nithin.core.common.workmanager.DeleteWorkerScheduler
import java.util.concurrent.TimeUnit

class DeletePaymentWorkScheduler(
    private val workManager: WorkManager
) : DeleteWorkerScheduler{

    override suspend fun scheduleDeleteWorker() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<DeletePaymentWorker>()
            .setConstraints(constraints)
            .setBackoffCriteria(
                BackoffPolicy.EXPONENTIAL,
                30,
                TimeUnit.SECONDS
            ).build()

        workManager.enqueueUniqueWork(
            "delete_payment_sync",
            ExistingWorkPolicy.KEEP,
            oneTimeWorkRequest
        )
    }
}
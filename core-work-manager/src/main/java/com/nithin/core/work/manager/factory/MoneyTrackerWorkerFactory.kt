package com.nithin.core.work.manager.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.nithin.core.common.workmanager.DeleteWorker
import com.nithin.core.common.workmanager.SyncManager
import com.nithin.core.work.manager.PaymentSyncWorker
import com.nithin.core.work.manager.delete_payment_worker.DeletePaymentWorker

class MoneyTrackerWorkerFactory(
    private val syncManager: SyncManager,
    private val deleteWorker: DeleteWorker
) : WorkerFactory(){
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when(workerClassName){
            PaymentSyncWorker::class.java.name -> {
                PaymentSyncWorker(
                    context = appContext,
                    workerParameters = workerParameters,
                    syncManager = syncManager
                )
            }
            DeletePaymentWorker::class.java.name->{
                DeletePaymentWorker(
                    context = appContext,
                    workerParameters = workerParameters,
                    deleteWorker = deleteWorker
                )
            }
            else -> null
        }
    }
}
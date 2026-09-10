package com.nithin.core.work.manager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.nithin.core.common.workmanager.SyncManager
import kotlinx.coroutines.CancellationException

class PaymentSyncWorker(
    private val context: Context,
    private val workerParameters: WorkerParameters,
    private val syncManager: SyncManager
) : CoroutineWorker(context, workerParameters){
    override suspend fun doWork(): Result {
        try {
            syncManager.syncData()
            return Result.success()
        }catch (cancelException: CancellationException){
            throw cancelException
        }catch (t: Exception){
            t.printStackTrace()
            return Result.retry()
        }
    }
}

